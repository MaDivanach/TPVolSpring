package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import repositories.ClientRepository;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		ReservationRepository aeroportRepository = ctx.getBean(ReservationRepository.class);
//		aeroportRepository.findCustomByIdWithVille((long) 100);
//		aeroportRepository.findCustomByIdWithVolArrive((long) 100);
//		aeroportRepository.findCustomByIdWithVolDepart((long) 100);
//		
//		VilleRepository villeRepository = ctx.getBean(VilleRepository.class);
//		villeRepository.findCustomAeroportByIdWithVille((long) 100);
//	
//		VolRepository volRepository = ctx.getBean(VolRepository.class);
//		volRepository.findCustomByIdWithEscale((long) 100);
//		volRepository.findCustomByIdWithCompagnieAerienne((long) 100);
//		volRepository.findCustomByIdWithReservation((long) 100);
		
//		List<Vol> voll = volRepository.findAll();
//		Set<Optional<Vol>> vols = new HashSet<Optional<Vol>>();
//		for(Vol v : voll) {
//			vols.add(volRepository.findCustomByIdWithReservation(v.getId()));
//		}
//		System.out.println(vols);
//		
//		PassagerRepository passagerRepository = ctx.getBean(PassagerRepository.class);
//		passagerRepository.findCustomByIdWithReservation((long) 100);
//	
		ClientRepository clientRepository = ctx.getBean(ClientRepository.class);
	
		
		System.out.println(clientRepository.findCustomByIdWithReservation((long) 50));
//		
//		
//		CompagnieAerienneRepository caRepository = ctx.getBean(CompagnieAerienneRepository.class);
//		caRepository.findCustomVolByIdWithCompagnie((long) 100);
//	
	}

}
