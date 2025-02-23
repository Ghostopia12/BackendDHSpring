package org.example.backend.models;

import jakarta.persistence.*;
import lombok.*;
import org.example.backend.enums.Status;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime creationDate;

    private LocalDateTime updateDate;

    public String getFormattedCreationDate() {
        return creationDate.format(DateTimeFormatter.ofPattern("yyyy*MM*dd HH|mm|ss"));
    }

    public String getFormattedUpdateDate() {
        return updateDate.format(DateTimeFormatter.ofPattern("yyyy*MM*dd HH|mm|ss"));
    }

    @PrePersist
    protected void onCreate() {
        this.creationDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updateDate = LocalDateTime.now();
    }
}
