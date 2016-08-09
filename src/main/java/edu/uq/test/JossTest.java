package edu.uq.test;


import org.javaswift.joss.client.factory.AccountFactory;
import org.javaswift.joss.model.Account;
import org.javaswift.joss.model.Container;
import org.javaswift.joss.model.StoredObject;


import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.Collection;

public class JossTest{

	
	



	public static void main(String[] args) {

		String username = "s4327550@student.uq.edu.au";
		String password = "";
		String authURL = "https://keystone.rc.nectar.org.au:5000/v2.0/tokens";
		String tenantName = "";
		String tenantID = "";

  		Account account = new AccountFactory()
            .setUsername(username)
            .setPassword(password)
            .setAuthUrl(authURL)
            .setTenantName(tenantName)
            .setTenantId(tenantID)
            .createAccount();
    	//create container
    	//Container container = account.getContainer("hoang");
	    //if (!container.exists()) {
        //    container.create();
        //    container.makePublic();
        //}
    	//list containers
		Collection<Container> containers = account.list();
	    for (Container currentContainer : containers) {
	        if(!currentContainer.getName().equals("_sc-coesra_compute")){
		    	boolean isPublic = currentContainer.isPublic();
		        System.out.println(currentContainer.getName());
	        	for (StoredObject object : currentContainer.list()) {
                    System.out.printf("  %s%n", object.getName());
                    if (isPublic) {
                        System.out.printf("Public URL: %s%n", object.getPublicURL());
                    }
                    System.out.printf("Type: %s%n    Size: %s%n    Last modified: %s%n    E-tag: %s%n", object.getContentType(), object.getContentLength(), object.getLastModified(), object.getEtag());
                    //printMetadata(true, object.getMetadata());
                    object.delete(); 
                }
		        currentContainer.delete();
	        }
	    }

	    //StoredObject object = container.getObject("card_1.jpeg");
	    //object.uploadObject(new File("/Users/hoangnguyen/Pictures/card_1.jpeg"));
	    //System.out.println("Public URL: "+object.getPublicURL());
	    //StoredObject object1 = container.getObject("Pictures/card_2.jpeg");
	    //object1.uploadObject(new File("/Users/hoangnguyen/Pictures/card_2.jpeg"));
	    //System.out.println("Public URL: "+object1.getPublicURL());

	    //Map<String, Object> metadata = new TreeMap<String, Object>();
	    //metadata.put("data", "1");
	    //metadata.put("versionID", "100");
	    //metadata.put("versionnum", "2");
	    //metadata.put("owner", "uqhngu36");
	    //metadata.put("readable", "uqmdinh1");
	    //metadata.put("writable", "uqmdinh1");
	    //container.setMetadata(metadata);


	}
} 
