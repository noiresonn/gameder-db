package com.gameder.db;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.TreeSet;
import java.io.*;

@RestController
public class Query {
    private static final String ENDPOINT = "/api/query";

    @CrossOrigin
    @RequestMapping(value = ENDPOINT, method = RequestMethod.GET)
    public void get(HttpServletResponse response) {
        try {
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(new TreeSet<Integer>());
            oos.close();
        } catch (IOException ex) {
            System.out.printf("'get' query failed: %s\n", ex.getLocalizedMessage());
        }
    }

    @CrossOrigin
    @RequestMapping(value = ENDPOINT, method = RequestMethod.POST)
    public void post(HttpServletRequest request) {
        try {
            BufferedInputStream bis = new BufferedInputStream(request.getInputStream());
            ObjectInputStream ois = new ObjectInputStream(bis);
            Object obj = ois.readObject();
            ois.close();

            TreeSet<Integer> tree = (TreeSet) obj;
            System.out.printf("YAY: %d", tree.first());
        } catch (Exception ex) {
            System.out.printf("'post' query failed: %s\n", ex.toString());
        }
    }
}