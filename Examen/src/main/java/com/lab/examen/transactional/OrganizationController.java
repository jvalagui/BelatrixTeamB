package com.lab.examen.transactional;

import com.lab.examen.model.Organization;
import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * Created by Kei on 21/05/2016.
 */
public class OrganizationController {

    public static void store(){

    }

    public static void update(){

    }

    public static void destroy(){

    }

    public static void list(){

    }

    public static void load(){

        Organization organization1 = new Organization(1,"Organization1");
        Organization organization2 = new Organization(2,"Organization2");

        AppExamenDB.getOrganizations().add(organization1);
        AppExamenDB.getOrganizations().add(organization2);
    }

    public static Organization search(){
        return null;
    }
}
