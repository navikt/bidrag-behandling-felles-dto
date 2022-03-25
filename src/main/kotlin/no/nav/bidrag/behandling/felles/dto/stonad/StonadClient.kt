package no.nav.bidrag.behandling.felles.dto.stonad

interface StonadClient {
  fun hentStonad(stonadId: Int): StonadDto

  fun endreMottakerIdOgOpprettHistorikk(request: EndreMottakerIdRequestDto): EndreMottakerIdDto
}