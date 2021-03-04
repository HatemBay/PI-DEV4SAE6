package tn.esprit.spring.user;

import java.util.List;

public interface sellerService {
	public int addSeller(seller sel);
	public seller findSel(int IdSeller);
	public List<seller> getAllSeller();
	public void updateSellerusename(int IdSeller, String username);
	public void updateSellerpassword(int IdSeller, String password);
	
	public void deleteSeller(int IdSeller);

}
