package com.ebsco.folio.nortecprocessing.domain.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@JsonRootName("NORTEC_INFO")
@Entity
@Table(name = "NORTEC_INFO")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nortec {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "ALTERNATE_TITLE")
    private String alternateTitle;
    @Column(name = "PACKAGE_NAME")
    private String packageName;
    @Column(name = "URL")
    private String Url;
    @Column(name = "EDITION")
    private String edition;
    @Column(name = "EDITOR")
    private String editor;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "SUBJECT")
    private String subject;
    @Column(name = "REV")
    private String rev;
    @Column(name = "SC")
    private String sc;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "STATUS")
    private String status;


}
