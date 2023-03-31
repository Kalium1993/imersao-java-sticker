package br.com.tlndev.imersaojava.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Nasa(String title, String url) {}
