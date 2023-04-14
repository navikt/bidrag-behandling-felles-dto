# bidrag-behandling-felles-dto

![](https://github.com/navikt/bidrag-behandling-felles-dto/workflows/maven%20deploy/badge.svg)

Inneholder DTOer (dataklasser) som brukes av flere repositories ifbm behandling av bidrag

## release endringer

| versjon | endringstype | beskrivelse                                                                                               |
|---------|--------------|-----------------------------------------------------------------------------------------------------------|
| 0.0.1   | Opprettet    | Initiell versjon                                                                                          |
| 0.0.2   | Opprettet    | Lagt til første klasser fra bidrag-stonad                                                                 |
| 0.0.3   | Opprettet    | Endret til å bruke kotlinfiler                                                                            |
| 0.0.4   | Opprettet    | Endret deploy.yaml                                                                                        |
| 0.0.5   | Opprettet    | Endret deploy.yaml og ny avhengighet til bidrag-commons                                                   |
| 0.0.6   | Opprettet    | Fjernet endretAv i OpprettStonadRequestDto                                                                |
| 0.0.7   | Opprettet    | Funksjoner brukt av bidrag-stonad lagt til VedtakHendelse                                                 |
| 0.0.8   | Opprettet    | Lagt til Dtoer for bidrag-vedtak                                                                          |
| 0.0.9   | Opprettet    | Grunnlag.innhold endret til JsonNode                                                                      |
| 0.0.10  | Opprettet    | Lagt til dto-klasser for bidrag-grunnlag                                                                  |
| 0.0.11  | Endret       | Fjernet id-felter fra dto'er som skal settes i bidrag-vedtak                                              |
| 0.0.12  | Endret       | Endret EngangsbelopType til enum                                                                          |
| 0.0.13  | Endret       | Erstattet GrunnlagType med GrunnlagRequestType for bidrag-grunnlag                                        |
| 0.0.14  | Endret       | Oppdatert versjon av bidrag-behandling-felles                                                             |
| 0.0.15  | Endret       | Fjernet bidrag-commons avhengighet                                                                        |
| 0.0.16  | Endret       | Lagt til dto'er for bidrag-grunnlag med persondata fra PDL                                                |
| 0.0.17  | Endret       | Noen navneendringer på dto'er for bidrag-grunnlag med persondata fra PDL                                  |
| 0.0.18  | Endret       | HentGrunnlagspakkeDto utvidet til å inneholde PDL-data                                                    |
| 0.0.19  | Endret       | Opprettet PersonDto                                                                                       |
| 0.0.20  | Endret       | Endret noen datoer til nullable                                                                           |
| 0.0.21  | Endret       | Endret noen datatyper                                                                                     |
| 0.0.22  | Endret       | Rettet skrivefeil                                                                                         |
| 0.0.23  | Endret       | Endret datatype                                                                                           |
| 0.0.24  | Endret       | Renamet Person til Forelder                                                                               |
| 0.0.25  | Endret       | Pom oppdatert med siste versjon av bidrag-behandling-felles                                               |
| 0.0.26  | Endret       | Fødsels- og dødsdato lagt til på husstandsmedlemmer                                                       |
| 0.0.27  | Endret       | Ny versjon bidrag-behandling-felles                                                                       |
| 0.0.28  | Endret       | innsynHistoriskeInntekterDato fjernet fra GrunnlagRequestDto                                              |
| 0.0.29  | Endret       | Lagt til personId i respons for PDL-data                                                                  |
| 0.0.30  | Endret       | Gjort personId nullable for PDL-data for å håndtere manuelle registreringer                               |
| 0.0.31  | Endret       | Endret navn voksneHusstandsmedlemmerListe -> husstandsmedlemmerListe                                      |   
| 0.0.32  | Endret       | Lagt til Dto for kontantstøtte for bruk mot infotrygd-kontantstotte-v2                                    |     
| 0.0.33  | Endret       | Endret periodeTil i kontantstøtte til nullable                                                            |     
| 0.0.34  | Endret       | opprettetTidspunkt endret tilbake til hentetTidspunkt                                                     |     
| 0.0.35  | Endret       | sakId lagt til for engangsbeløp                                                                           |     
| 0.0.36  | Endret       | Lagt tilbake logikk for sporing                                                                           |     
| 0.0.37  | Endret       | Lagt til Dto for barnetilsyn for bruk mot familie-ef-sak                                                  |     
| 0.0.38  | Endret       | Oppdatert versjon av bidrag-behandling-felles                                                             |     
| 0.0.39  | Endret       | Endre alle felt i responsklasser for bidrag-grunnlag til nullable                                         |     
| 0.0.40  | Endret       | Endre tilbake forrige endring pga følgefeil. Avventer dette.                                              |     
| 0.0.41  | Endret       | Nytt forsøk.                                                                                              |     
| 0.0.42  | Endret       | Oppdaterer barnetilsynDto slik at beløp og skoelalder kan være nullable                                   |     
| 0.0.43  | Endret       | Fjernet unødvendige avhengigheter                                                                         |     
| 0.0.44  | Endret       | Fjernet behandlingId fra stønadsendring på vedtak + lagt tilbake build-plugins i pom                      |     
| 0.0.45  | Endret       | VedtakHendelse omskrevet, er nå basert på OpprettVedtakRequestDto                                         |     
| 0.0.46  | Endret       | Noen rettinger på ny VedtakHendelse                                                                       |     
| 0.0.47  | Endret       | Referanse lagt til på engangsbeløp og periode under stønadsendring, skal brukes av bidrag-regnskap        |     
| 0.0.48  | Endret       | Justeringer VedtakHendelse og vedtaksDto                                                                  |     
| 0.0.49  | Endret       | utsattTilDato og eksternReferanse lagt til på vedtak request og response                                  |     
| 0.0.50  | Endret       | endrerEngangsbelopId lagt til på Engangsbelop -> Kafka-topic.                                             |     
| 0.0.51  | Endret       | indeksreguleringAar lagt til på stønadsendringsnivå for bidrag-vedtak                                     |     
| 0.0.52  | Endret       | indeksreguleringAar lagt til på stønadnivå for bidrag-stonad                                              |     
| 0.0.53  | Endret       | beløp og valutakode gjort nullable på engangsbeløp, nytt felt opphortFra på stønadsendring                |     
| 0.0.54  | Endret       | sakId gjort non-nullable                                                                                  |     
| 0.0.55  | Endret       | belop og valutakode gjort om til nullable på periode i bidrag-vedtak                                      |     
| 0.0.56  | Endret       | Fjerner felt opphortFra fra stønadsendring                                                                |     
| 0.0.57  | Endret       | Endrer inputkontroll på skyldner/mottaker/kravhaver, fjernet db-id i respons fra vedtak                   |     
| 0.0.58  | Endret       | OpphortFra fjernet fra bidrag-stonad, beløp og valuutakode gort nullable                                  |     
| 0.0.59  | Endret       | Bidrag-vedtak: Kilde lagt til på vedtak, innkreving på stonadsendring og engangsbelop + noe refaktorering |     
| 0.0.60  | Endret       | Bidrag-stonad: innkreving lagt til på stønad + noe refaktorering                                          |     
| 0.0.61  | Endret       | Bidrag-vedtak: Endret til type BehandlingsrefKilde på tabell behandlingsreferanse                         |     
| 0.0.62  | Endret       | Bidrag-vedtak: Endret til type BehandlingsrefKilde på objekter for behandlingsreferanse                   |     
| 0.0.63  | Endret       | Bidrag-stonad: Nytt request-objekt for å hente stønader                                                   |     
| 0.0.64  | Endret       | Ny versjon av bidrag-behandling-felles                                                                    |     
| 0.0.65  | Endret       | Bidrag-vedtak: Dato erstattet med vedtakTidspunkt                                                         |
| 0.0.66  | Endret       | Bidrag-stonad: GyldigFra og GyldigTil lagt til på periode                                                 |
| 0.0.67  | Endret       | Bidrag-vedtak-og-stonad: Timestamp -> tidspunkt                                                           |
| 0.0.68  | Endret       | Oppdatert versjon av bidrag-commons + tilpasninger CorrelationId                                          |
| 0.0.69  | Endret       | Fjernet behov for bidrag-commons, fjernet fra pom                                                         |
| 0.0.70  | Endret       | Ny boolean endring                                                                                        |
| 0.0.71  | Endret       | Lagt til ny request for å hente stønad og gyldige perioder for angitt tidspunkt                           |
| 0.0.72  | Endret       | Tilpasninger mot vedtal, omgjorVedtakId og referanse. Fjerner endrerEngangsbelopId                        |
| 0.0.73  | Endret       | Endrer omgjorVedtakId fra String til Int                                                                  |
| 0.0.74  | Endret       | Endrer referanse til non-nullable                                                                         |
| 0.0.75  | Endret       | Tilpasninger format pdl-data i grunnlag                                                                   |
| 0.0.76  | Endret       | Fjernet bl.a info om husstand da vi ikke trenger å lagre dette i bidrag-grunnlag                          |
| 0.0.77  | Endret       | Restrukturering av respons med pdl-data fra bidrag-grunnlag                                               |
| 0.0.78  | Endret       | Restrukturering av respons med pdl-data fra bidrag-grunnlag noch einmal                                   |
| 0.0.79  | Endret       | Husstandsmedlem renames til relatertPerson - bidrag-grunnlag                                              |
| 0.0.80  | Endret       | Ny klasse bidrag.grunnlag OvergangsstønadDto                                                              |
| 0.0.81  | Endret       | Legger med overgangsstønad i HentGrunnlagspakkeDto                                                        |
| 0.0.82  | Endret       | Endrer fra overgangsstønad til overgangsstonad pga feil i tester                                          |
| 0.0.83  | Endret       | Forbedrer beskrivelser av grunnlag, lagt til felter på SivilstandDto                                      |