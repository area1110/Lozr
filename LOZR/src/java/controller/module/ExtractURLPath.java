/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.module;


/**
 *
 * @author Khanh
 */
public class ExtractURLPath {

    public static int extractPathToID(String path) {
        int ID;
        if (path == null) {
            ID = 0;
        } else if (path.matches("|/\\d+")) {
            ID = Integer.parseInt(path.split("[/]")[1]);
        } else {
            ID = Integer.parseInt(path.split("[.]")[1]);
        }

        return ID;
    }

    public static String compressObjectToPath(String rootPath, String servletPath, String name, int parentID) {
        String path = "";

        path = rootPath + "/" + servletPath + "/" + name + "." + parentID;

        return path;
    }
}
