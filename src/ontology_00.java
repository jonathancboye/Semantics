import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.sparql.*;
import com.hp.hpl.jena.sparql.engine.QueryEngineFactory;


public class ontology_00 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model model = ModelFactory.createDefaultModel();
		model.read("owl/eswc-2006-09-21.rdf");
		OntModel Omodel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM_RULE_INF, model);
		Model base = Omodel.getBaseModel();
		Model diff = base.difference(model);
		Model intersection = base.intersection(model);
		
		intersection.write(System.out);
				
	}

}
