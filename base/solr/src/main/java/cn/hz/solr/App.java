package cn.hz.solr;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;

public class App {
	public static void main(String[] args) throws SolrServerException, IOException {
		String urlString = "http://localhost:8983/solr/techproducts";
		SolrClient solr = new HttpSolrClient(urlString);
		
		SolrQuery parameters = new SolrQuery();
		parameters.set("q", "w");
		
		QueryResponse response = solr.query(parameters);
		System.out.println(response);
	}
}
