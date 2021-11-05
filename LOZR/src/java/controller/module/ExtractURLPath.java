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
        try {
            int ID;
            if (path == null) {
                ID = -1;
            } else if (path.matches("|/\\d+")) {
                ID = Integer.parseInt(path.split("[/]")[1]);
            } else {
                ID = Integer.parseInt(path.split("[.]")[1]);
            }
            return ID;
        } catch (ArrayIndexOutOfBoundsException aie) {
            return -1;
        }
    }

    public static String compressObjectToPath(String rootPath, String servletPath, String name, int parentID) {
        String path;
        name = name.toLowerCase().replaceAll("[ ?#/.\\\\]", "-");//hide all the key characs at request url
        path = rootPath + "/" + servletPath + "/" + name + "." + parentID;
        return path;
    }
}
