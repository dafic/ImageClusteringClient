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
import java.math.BigDecimal;
import javax.imageio.ImageIO;
import javax.naming.spi.DirStateFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

/**
 *
 * @author bhanu bhakta
 */
public class GetHBaseGMM {

    public void getGMM() throws IOException, ClassNotFoundException {
        Configuration config = GrailsConfiguration.getConfig();
        HTable table = new HTable(config, "ImageDatabase");
        Get get = new Get(Bytes.toBytes("bilkes10.jpg"));
        Result result = table.get(get);
        byte[] val = result.getValue(Bytes.toBytes("Image"), Bytes.toBytes("split0"));
        //if(val == null)
        System.out.println(val.length+":"+val);
        InputStream in = new ByteArrayInputStream(val);
        BufferedImage bif = ImageIO.read(in);
        if(bif == null){
            System.out.println("buff image null");
        }
//        BufferedImage bif = (BufferedImage)ObjectToByte.ByteArrayToObject(val);
        ImageIO.write(bif, "jpg", new File(
                "test_new.jpg"));
    }
}
