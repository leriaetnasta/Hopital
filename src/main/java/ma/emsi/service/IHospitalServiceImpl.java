package ma.emsi.service;

import ma.emsi.entities.Consultation;
import ma.emsi.entities.Medecin;
import ma.emsi.entities.Patient;
import ma.emsi.entities.RendezVous;
import ma.emsi.repositories.ConsultationRepository;
import ma.emsi.repositories.MedecinRepository;
import ma.emsi.repositories.PatientRepository;
import ma.emsi.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class IHospitalServiceImpl implements IHopitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public IHospitalServiceImpl(PatientRepository patientRepository,
                                MedecinRepository medecinRepository,
                                RendezVousRepository rendezVousRepository,
                                ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository=medecinRepository;
        this.rendezVousRepository=rendezVousRepository;
        this.consultationRepository=consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save((patient));
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save((medecin));
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
