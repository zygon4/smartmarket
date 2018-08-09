/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zygon.smartmarket.campaign.execute;

import com.zygon.smartmarket.Prospect;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author zygon
 */
public class ProspectLoader {

    private static Optional<String> emptyToNull(String str) {
        return Optional.ofNullable(str.isEmpty() ? null : str);
    }

    public static List<Prospect> load(Path prospectCSV) throws IOException {

        List<Prospect> prospects = new ArrayList<>();

        try (Reader in = new BufferedReader(new FileReader(prospectCSV.toFile()))) {
            for (CSVRecord record : CSVFormat.DEFAULT.parse(in)) {
                int i = 0;

                String email = null;
                Optional<String> firstName = null;
                Optional<String> lastName = null;

                for (String field : record) {
                    switch (i++) {
                        case 0:
                            email = field;
                            break;
                        case 1:
                            firstName = emptyToNull(field);
                            break;
                        case 2:
                            lastName = emptyToNull(field);
                            break;
                    }

                    if (i > 3) {
                        // Ignore other fields for now
                        break;
                    }
                }

                prospects.add(new ProspectImpl(email, firstName, lastName));
            }

            return prospects;
        }
    }
}
