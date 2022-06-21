# bidrag-behandling-felles-dto

![](https://github.com/navikt/bidrag-behandling-felles-dto/workflows/maven%20deploy/badge.svg)

Inneholder DTOer (dataklasser) som brukes av flere repositories ifbm behandling av bidrag

## release endringer

| versjon | endringstype | beskrivelse                                                              |
|---------|--------------|--------------------------------------------------------------------------|
| 0.0.1   | Opprettet    | Initiell versjon                                                         |
| 0.0.2   | Opprettet    | Lagt til første klasser fra bidrag-stonad                                |
| 0.0.3   | Opprettet    | Endret til å bruke kotlinfiler                                           |
| 0.0.4   | Opprettet    | Endret deploy.yaml                                                       |
| 0.0.5   | Opprettet    | Endret deploy.yaml og ny avhengighet til bidrag-commons                  |
| 0.0.6   | Opprettet    | Fjernet endretAv i OpprettStonadRequestDto                               |
| 0.0.7   | Opprettet    | Funksjoner brukt av bidrag-stonad lagt til VedtakHendelse                |
| 0.0.8   | Opprettet    | Lagt til Dtoer for bidrag-vedtak                                         |
| 0.0.9   | Opprettet    | Grunnlag.innhold endret til JsonNode                                     |
| 0.0.10  | Opprettet    | Lagt til dto-klasser for bidrag-grunnlag                                 |
| 0.0.11  | Endret       | Fjernet id-felter fra dto'er som skal settes i bidrag-vedtak             |
| 0.0.12  | Endret       | Endret EngangsbelopType til enum                                         |
| 0.0.13  | Endret       | Erstattet GrunnlagType med GrunnlagRequestType for bidrag-grunnlag       |
| 0.0.14  | Endret       | Oppdatert versjon av bidrag-behandling-felles                            |
| 0.0.15  | Endret       | Fjernet bidrag-commons avhengighet                                       |
| 0.0.16  | Endret       | Lagt til dto'er for bidrag-grunnlag med persondata fra PDL               |
| 0.0.17  | Endret       | Noen navneendringer på dto'er for bidrag-grunnlag med persondata fra PDL |
| 0.0.18  | Endret       | HentGrunnlagspakkeDto utvidet til å inneholde PDL-data                   |
| 0.0.19  | Endret       | Opprettet PersonDto                                                      |
| 0.0.20  | Endret       | Endret noen datoer til nullable                                          |
| 0.0.21  | Endret       | Endret noen datatyper                                                    |
| 0.0.22  | Endret       | Rettet skrivefeil                                                        |
| 0.0.23  | Endret       | Endret datatype                                                          |
| 0.0.24  | Endret       | Renamet Person til Forelder                                              |
| 0.0.25  | Endret       | Pom oppdatert med siste versjon av bidrag-behandling-felles              |
| 0.0.26  | Endret       | Fødsels- og dødsdato lagt til på husstandsmedlemmer                      |
| 0.0.27  | Endret       | Ny versjon bidrag-behandling-felles                                      |
| 0.0.28  | Endret       | innsynHistoriskeInntekterDato fjernet fra GrunnlagRequestDto             |
