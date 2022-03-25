package no.nav.bidrag.behandling.felles.dto.stonad

interface MottakerIdHistorikkClient {
  fun finnAlleEndringerMottakerIdForStonad(stonadId: Int): StonadDto
}