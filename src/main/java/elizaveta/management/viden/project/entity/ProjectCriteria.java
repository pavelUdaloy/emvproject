package elizaveta.management.viden.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "project_criteries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectCriteria {

    @EmbeddedId
    private ProjectCriteriaId id;

    @Column
    private String status;

    @Column
    private String description;

    @Column
    private LocalDateTime deadline;

    @ManyToOne
    @MapsId("projectId")
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User analyst;

    @ManyToOne
    @MapsId("criteriaId")
    @JoinColumn(name = "criteria_id", nullable = false)
    private Criteria criteria;

    @OneToMany(mappedBy = "projectCriteria")
    private List<Note> notes;

    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class ProjectCriteriaId implements Serializable {

        private int projectId;
        private int criteriaId;
    }
}
