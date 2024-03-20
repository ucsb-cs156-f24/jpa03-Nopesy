package edu.ucsb.cs156.example.services;

import com.github.tomakehurst.wiremock.WireMockServer;

public abstract class WiremockService {
  public abstract WireMockServer getWiremockServer();
  public abstract void init();
}
