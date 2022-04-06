package ma.emsi;

import ma.emsi.entities.Consultation;
import ma.emsi.entities.Medecin;
import ma.emsi.entities.Patient;
import ma.emsi.entities.RendezVous;
import ma.emsi.repositories.ConsultationRepository;
import ma.emsi.repositories.MedecinRepository;
import ma.emsi.repositories.PatientRepository;
import ma.emsi.repositories.RendezVousRepository;
import ma.emsi.service.IHopitalService;
import ma.emsi.service.IHospitalServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HopitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HopitalApplication.class, args);


	}
	@Bean
	CommandLineRunner start(IHopitalService iHopitalService,
							PatientRepository patientRepository,
							MedecinRepository medecinRepository,
							RendezVousRepository rendezVousRepository){
		return args->{
			Stream.of("loubna", "hayat", "hamza")
					.forEach(name->{
								Patient patient = new Patient();
								patient.setDatenaissane(new Date());
								patient.setNom(name);
								patient.setMalade(false);
								iHopitalService.savePatient(patient);
							}

					);
			Stream.of("loubna", "hayat", "hamza")
					.forEach(name->{
								Medecin medecin = new Medecin();
								medecin.setNom(name);
								medecin.setEmail(name+"@gmail.com");
								medecin.setSpecialite("dentaire");
								iHopitalService.saveMedecin(medecin);
							}

					);
			Patient patient= patientRepository.findById(1L).orElse(null);
			Medecin medecin= medecinRepository.findById(1L).orElse(null);
			RendezVous rendezVous= new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient);
			RendezVous saveRDZ=iHopitalService.saveRendezVous(rendezVous);
			System.out.println(saveRDZ.getId());
			Consultation consultation= new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRapport("Rapport de la consulation");
			consultation.setRendezVous(rendezVous);
			iHopitalService.saveConsultation(consultation);

		};


	}

}
