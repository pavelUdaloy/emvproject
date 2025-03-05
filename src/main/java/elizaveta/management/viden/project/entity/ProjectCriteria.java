package elizaveta.management.viden.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

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
    @MapsId("criteriaId")
    @JoinColumn(name = "criteria_id", nullable = false)
    private Criteria criteria;

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
