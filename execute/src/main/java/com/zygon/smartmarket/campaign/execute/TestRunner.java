/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zygon.smartmarket.campaign.execute;

import com.zygon.smartmarket.Prospect;
import com.zygon.smartmarket.campaign.Segment;

import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author zygon
 */
public class TestRunner {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws Exception {
        URL prospectsURL = TestRunner.class.getResource("prospects.csv");
        List<Prospect> prospects = ProspectLoader.load(Paths.get(prospectsURL.toURI()));
        for (Prospect prospect : prospects) {
            System.out.println(prospect);
        }

        Segment segment = new SegmentImpl("TODO", prospects, Segment.SendRate.WEEKLY, "Plz sign up");

        SegmentManager segmentManager = new SegmentManager(segment, (prospect, message) -> {
            System.out.println("Sending message " + message + " to prospect " + prospect);
        });

        segmentManager.startAsync();

        Thread.sleep(TimeUnit.SECONDS.toMillis(30));

        segmentManager.stopAsync();
    }

}
