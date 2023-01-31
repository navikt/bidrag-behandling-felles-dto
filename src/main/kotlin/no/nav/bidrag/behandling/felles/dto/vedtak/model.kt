package no.nav.bidrag.behandling.felles.dto.vedtak

import no.nav.bidrag.behandling.felles.enums.EngangsbelopType
import no.nav.bidrag.behandling.felles.enums.Innkreving
import no.nav.bidrag.behandling.felles.enums.StonadType
import no.nav.bidrag.behandling.felles.enums.VedtakKilde
import no.nav.bidrag.behandling.felles.enums.VedtakType
import no.nav.bidrag.commons.CorrelationId
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

data class VedtakHendelse(
  val kilde: VedtakKilde,
  val type: VedtakType,
  val id: Int,
  val vedtakTidspunkt: LocalDateTime,
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
    CorrelationId.Companion.fetchCorrelationIdForThread()
      ?: CorrelationId.Companion.generateTimestamped(type.toString())
        .get()
  )
}

data class Sporingsdata(val correlationId: String) {
  var brukerident: String? = null

  @Suppress("unused") // brukes av jackson
  val opprettet: LocalDateTime = LocalDateTime.now()
  val opprettetAv: String? = null
}

data class Stonadsendring(
  val type: StonadType,
  val sakId: String,
  val skyldnerId: String,
  val kravhaverId: String,
  val mottakerId: String,
  val indeksreguleringAar: String?,
  val innkreving: Innkreving,
  val periodeListe: List<Periode>
)

data class Engangsbelop(
  val id: Int,
  val type: EngangsbelopType,
  val sakId: String,
  val skyldnerId: String,
  val kravhaverId: String,
  val mottakerId: String,
  val belop: BigDecimal?,
  val valutakode: String?,
  val resultatkode: String,
  val referanse: String?,
  val innkreving: Innkreving,
  val endrerId: Int?
)

data class Periode(
  val fomDato: LocalDate,
  val tilDato: LocalDate?,
  val belop: BigDecimal?,
  val valutakode: String?,
  val resultatkode: String,
  val referanse: String?
  )