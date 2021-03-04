package tn.esprit.spring.Reclamation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ReclamationServiceImpl implements ReclamationService {

@Autowired
	ReclamationRepository rec;
	
	@Override
	public int addReclamation(Reclamation recla) {
		return rec.save(recla).getIdRec();
	}

	@Override
	public Reclamation findRec(int IdRec) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reclamation> getAllReclamation() {
		return rec.findAll();
		
	}

	@Override
	public void updateReclamationDescription(int IdRec, String Description) {
		Reclamation oldRec = findRec(IdRec);
		oldRec.setDescription(Description);
		addReclamation(oldRec);
		
	}

	public void updateReclamationType(int IdRec, String type) {
		Reclamation oldRec = findRec(IdRec);
		oldRec.setType(Type.valueOf(type.toUpperCase()));
		addReclamation(oldRec);
	}

	

	@Override
	public void deleteReclamation(int IdRec) {
		rec.deleteById(IdRec);

		
	}

	

}
