package tn.esprit.spring.Reclamation;
import java.util.List;
public interface ReclamationService {
	public int addReclamation(Reclamation rec);
	public Reclamation findRec(int IdRec);
	public List<Reclamation> getAllReclamation();
	public void updateReclamationDescription(int IdRec, String Description);
	public void updateReclamationType(int IdRec, String Type);
	
	public void deleteReclamation(int IdRec);
}





