/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imageclustering.client;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

/**
 *
 * @author bhanu
 */
public class ImageAccess {
    public BufferedImage getImage(String tableName,String rowKey,Configuration config) throws IOException{
        byte[] val = null;
        HTable table = new HTable(config, tableName);
        Get get = new Get(Bytes.toBytes(rowKey));
        Result result = table.get(get);
        for(KeyValue kv: result.list()){
            val = kv.getValue();
        }
         //byte[] val = result.getValue(Bytes.toBytes("Image"), Bytes.toBytes("split0"));
         if(val == null){
             System.out.println("Null value");
         }
        //System.out.println(val.length + ":" + Bytes.toString(val));
        InputStream in = new ByteArrayInputStream(val);
        BufferedImage bif = ImageIO.read(in);
        if (bif == null) {
            return null;
        } else {
            return bif;
        }
    }
}
