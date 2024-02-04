package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobItem;

import lombok.val;

@Service
public class MyBlobService {

	@Value("${azure.myblob.url}")
	private String azureBlobUrl;

	@Value("${azure.myblob.container}")
	private String azureBlobContainer;

	public BlobContainerClient getClient() {
		BlobServiceClient containerClient = new BlobServiceClientBuilder().connectionString(azureBlobUrl).buildClient();
		BlobContainerClient container = containerClient.getBlobContainerClient(azureBlobContainer);
		return container;
	}
	
	public List<String> listFiles(){
		BlobContainerClient containerClient =  getClient();
		List<String> list = new ArrayList<>();
		for(BlobItem blobItem:containerClient.listBlobs()) {
			list.add( blobItem.getName());
		}
		return list;
	}
}
