package org.fogbeam.jenatutorial.rdf;

import java.io.FileOutputStream;

import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import com.hp.hpl.jena.query.Dataset;
import com.hp.hpl.jena.query.DatasetFactory;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;

public class ReadRDFXML_WriteJSONLD 
{


	public static void main(String[] args) throws Exception
	{
		Dataset dataset = DatasetFactory.createMem();
		RDFDataMgr.read(dataset, "file:/development/presentations/trijug_semantic/JenaTutorial/data/input/rdfxml/customers.rdf.xml", Lang.RDFXML);
		
		Model model = dataset.getDefaultModel();
		
		FileOutputStream fos = new FileOutputStream( "/development/presentations/trijug_semantic/JenaTutorial/data/output/jsonld/customers.rdf.jsonld" );
		RDFDataMgr.write( fos, model, Lang.JSONLD );
		fos.close();
	}
}