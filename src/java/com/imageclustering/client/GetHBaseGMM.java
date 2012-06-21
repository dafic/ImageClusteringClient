/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imageclustering.client;

import com.imageclustering.client.conf.GrailsConfiguration;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

/**
 *
 * @author bhanu bhakta
 */
public class GetHBaseGMM {

    public BufferedImage getGMM() throws IOException, ClassNotFoundException {
        Configuration config = GrailsConfiguration.getConfig();
        HTable table = new HTable(config, "ImageDatabase");
        Get get = new Get(Bytes.toBytes("tmnt_poster.jpg"));
        Result result = table.get(get);
        byte[] val = result.getValue(Bytes.toBytes("Image"), Bytes.toBytes("split0"));
        //if(val == null)
        System.out.println(val.length + ":" + val);
        InputStream in = new ByteArrayInputStream(val);
        BufferedImage bif = ImageIO.read(in);
        if (bif == null) {
            return null;
        } else {
//        BufferedImage bif = (BufferedImage)ObjectToByte.ByteArrayToObject(val);
//        ImageIO.write(bif, "jpg", new File(
//                "tmnt_poster.jpg"));
            return bif;
        }
    }

    public List<BufferedImage> scanTable(String tableName, Configuration config) throws IOException {
//        Configuration config = GrailsConfiguration.getConfig();
        List<BufferedImage> li = new ArrayList<BufferedImage>();
        HTable table = new HTable(config, tableName);
        Scan scan = new Scan();
        ResultScanner rs = table.getScanner(scan);
        Result r = null;
        while ((r = rs.next()) != null) {
            for (KeyValue kv : r.list()) {
                String fileName = Bytes.toString(kv.getRow());
                byte[] value = kv.getValue();
                InputStream in = new ByteArrayInputStream(value);
                BufferedImage bif = ImageIO.read(in);
                li.add(bif);
            }
        }
        return li;
    }
}
