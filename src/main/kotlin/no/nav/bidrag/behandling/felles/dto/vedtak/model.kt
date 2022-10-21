package no.nav.bidrag.behandling.felles.dto.vedtak

import no.nav.bidrag.behandling.felles.enums.EngangsbelopType
import no.nav.bidrag.behandling.felles.enums.StonadType
import no.nav.bidrag.behandling.felles.enums.VedtakType
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import no.nav.bidrag.commons.CorrelationId

data class VedtakHendelse(
  val vedtakType: VedtakType,
  val vedtakId: Int,
  val vedtakDato: LocalDate,
  val enhetId: String,
  val eksternReferanse: String?,
  val utsattTilDato: LocalDate?,
  val opprettetAv: String,
  val opprettetTidspunkt: LocalDateTime,
  val stonadsendringListe: List<Stonadsendring>?,
  val engangsbelopListe: List<Engangsbelop>?
)
{
  val sporing: Sporingsdata = Sporingsdata(
    CorrelationId.fetchCorrelationIdForThread()
      ?: CorrelationId.generateTimestamped(vedtakType.toString())
        .get()
  )
}

data class Sporingsdata(val correlationId: String) {
  var brukerident: String? = null

  @Suppress("unused") // brukes av jackson
  val opprettet: LocalDateTime = LocalDateTime.now()
  var opprettetAv: String? = null
}

data class Stonadsendring(
  val stonadType: StonadType,
  val sakId: String,
  val skyldnerId: String,
  val kravhaverId: String,
  val mottakerId: String,
  val periodeListe: List<Periode>
)

data class Engangsbelop(
  val engangsbelopId: Int,
  val type: EngangsbelopType,
  val sakId: String,
  val skyldnerId: String,
  val kravhaverId: String,
  val mottakerId: String,
  val belop: BigDecimal,
  val valutakode: String,
  val resultatkode: String,
  val referanse: String?
)

data class Periode(
  val periodeFomDato: LocalDate,
  val periodeTilDato: LocalDate?,
  val belop: BigDecimal,
  val valutakode: String,
  val resultatkode: String,
  val referanse: String?
  )