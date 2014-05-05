/*
 * Copyright (C) 2014 Miguel Gamboa at CCISEL
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package pt.isel.mpd14.raffle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class Dealer {

    List<Student> stds;

    
    public Dealer(URL path) throws IOException {
        initStudentsFromThoth(path);
    }
    

    private void initStudentsFromThoth(URL path) throws IOException {
        URLConnection connection = path.openConnection();
        connection.setRequestProperty("Accept-Charset", "UTF-8");
        InputStream response = connection.getInputStream();
        
        DealerStudentMapper mapper = new DealerStudentMapper();
        
        this.stds = new BufferedReader(new InputStreamReader(response))
                .lines()
                .filter(mapper::hasStudentInfo)
                .map(mapper::mapToStudent)
                .collect(Collectors.toList());

    }
    
    public Student randStudent() {
        Random random = new Random();
        Object[] st = stds.stream().filter(s -> s.grade > 5 && s.grade < 20).toArray();
        return (Student) st[(random.nextInt(st.length - 1))];
    }

    
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        stds.forEach(s -> res.append(s).append("\n"));
        return res.toString();
    }
    
    
    public void print() {
        System.out.println(this.toString());
    }

}
