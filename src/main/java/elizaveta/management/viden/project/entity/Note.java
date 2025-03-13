package elizaveta.management.viden.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "notes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String message;

    @Column(name = "sended_at", nullable = false)
    private LocalDateTime sendedAt;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "project_id", referencedColumnName = "project_id", nullable = false),
            @JoinColumn(name = "criteria_id", referencedColumnName = "criteria_id", nullable = false)
    })
    private ProjectCriteria projectCriteria;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "root_note_id")
    private Note rootNote;

    @OneToMany(mappedBy = "rootNote", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note> childNotes;
}
