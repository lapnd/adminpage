package com.hugelist.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.IOContext;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

public enum LuceneUtil {
	INSTANCE;

	private Directory directory;
	private IndexWriter indexWriter;
	private Analyzer analyzer;

	public Directory getDirectory() {
		return directory;
	}

	public Analyzer getAnalyzer() {
		return analyzer;
	}

	public IndexWriter getIndexWriter() {

		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(
				Version.LUCENE_CURRENT, analyzer);
		indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
		try {
			indexWriter = new IndexWriter(directory, indexWriterConfig);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		return indexWriter;
	}

	{
		analyzer = new StandardAnalyzer(Version.LUCENE_CURRENT);
		directory = new RAMDirectory();
//		Directory hd = getDirecotoryHD();
//		backup(hd, directory);
	}
	
	private void deleteFile(File file)
	    	throws IOException{
	 
	    	if(file.isDirectory()){
	 
	    		//directory is empty, then delete it
	    		if(file.list().length==0){
	 
	    		   file.delete();
	    		   System.out.println("Directory is deleted : " 
	                                                 + file.getAbsolutePath());
	 
	    		}else{
	 
	    		   //list all the directory contents
	        	   String files[] = file.list();
	 
	        	   for (String temp : files) {
	        	      //construct the file structure
	        	      File fileDelete = new File(file, temp);
	 
	        	      //recursive delete
	        	      deleteFile(fileDelete);
	        	   }
	 
	        	   //check the directory again, if empty then delete it
	        	   if(file.list().length==0){
	           	     file.delete();
	        	     System.out.println("Directory is deleted : " 
	                                                  + file.getAbsolutePath());
	        	   }
	    		}
	 
	    	}else{
	    		//if file, then delete it
	    		file.delete();
	    		System.out.println("File is deleted : " + file.getAbsolutePath());
	    	}
	    }

	private Directory getDirecotoryHD() {
		
		File file = null;
		
		String OS = System.getProperty("os.name").toLowerCase();
		
		if(OS.indexOf("win") >= 0){
			file = new File("D://lucene/campaign/");
		}
		else if(OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0){
			file = new File("/home/lapd/HugeListServer/server/data/luceneIndex");
		}

//		System.out.println("getAbsolutePath : " + file.getAbsolutePath()); 
		
		if (!file.exists()) {
			file.mkdirs();
		}
		else {
			try {
				//FileUtils.deleteDirectory(file);
				deleteFile(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			file.mkdirs();
		}
		
		try {
			return FSDirectory.open(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void backupToHD() {
		Directory hd = getDirecotoryHD();
		backup(directory, hd);
	}

	private void backup(Directory deDiretorio, Directory paraDiretoria) {

		try {
			for (String file : deDiretorio.listAll()) {
				deDiretorio.copy(paraDiretoria, file, file, IOContext.DEFAULT);
			}
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
}

