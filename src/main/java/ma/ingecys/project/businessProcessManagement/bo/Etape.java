package ma.ingecys.project.businessProcessManagement.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Etape implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtape;
    private int indexLigne;
    private int indexColonne;
    private int ordre;
    private String description;
    private int pourcentage;
    private int dureeEstimee;
    private int delaiAttente;
    private boolean isFirst;
    private boolean isEnd;
    private boolean isValidate;
    private boolean isPaid;
    @ManyToOne
    @JoinColumn(name = "idProcessus")
    private Processus processus;
    @ManyToOne
    @JoinColumn(name = "idCategorie")
    private Categorie categorie;
    @ManyToOne
    @JoinColumn(name = "idType")
    private Type type;
    @Enumerated(EnumType.STRING)
    private StatutEtape statutEtape;
    @ManyToOne
    @JoinColumn(name = "idResponsable")
    private Responsable valide_par;
    @OneToMany(mappedBy = "from",cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Connexion> suivants;
    @OneToMany(mappedBy = "to",cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Connexion> precedents;

}