package no.nav.bidrag.behandling.felles.dto.stonad

import no.nav.bidrag.behandling.felles.enums.StonadType
import no.nav.bidrag.behandling.felles.enums.VedtakType
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import no.nav.bidrag.commons.CorrelationId

data class VedtakHendelse(
  val vedtakId: Int,
  val vedtakType: VedtakType,
  val stonadType: StonadType,
  val sakId: String?,
  val skyldnerId: String,
  val kravhaverId: String,
  val mottakerId: String,
  val opprettetAv: String,
  val opprettetTimestamp: LocalDateTime,
  val periodeListe: List<VedtakHendelsePeriode>
) {
  val sporing: Sporingsdata = Sporingsdata(
    CorrelationId.fetchCorrelationIdForThread() ?: CorrelationId.generateTimestamped(stonadType.toString())
      .get()
  )
}

data class Sporingsdata(val correlationId: String) {
  var brukerident: String? = null

  @Suppress("unused") // brukes av jackson
  val opprettet: LocalDateTime = LocalDateTime.now()
  var opprettetAv: String? = null
}

data class VedtakHendelsePeriode(
  val periodeFom: LocalDate = LocalDate.now(),
  val periodeTil: LocalDate? = null,
  val belop: BigDecimal = BigDecimal.ZERO,
  val valutakode: String = "NOK",
  val resultatkode: String = "",
)