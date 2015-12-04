/**
 * 
 */
package de.subreport.elvis.shared.ted;

import java.math.BigInteger;
import java.util.Date;

import de.marco.test.annotations.Mapping;
import de.subreport.elvis.shared.ted.annotations.TedMaxLength;
import de.subreport.elvis.shared.ted.annotations.TedRequired;
import de.subreport.elvis.shared.ted.enums.Duration;
import de.subreport.elvis.shared.ted.enums.Renewal;
import de.subreport.elvis.shared.ted.enums.Variants;

/**
 * @author Rolf
 *
 */
public class ObjectDescriptionF01F02F05 extends ObjectDescription {

	// Nr. 6. Geschätzter Wert
	private Val valObject = new Val();

	// Nr. 7. Laufzeit des Vertrages, der Rahmenvereinbarung oder des dynamischen Beschaffungssystems
	private Duration duration = Duration.MONTH;
	private BigInteger durationMonth;	// DURATION.TYPE mus auch MONTH stehen
	private BigInteger indays;	// DURATION.TYPE muss auf DAY stehen
	private Date starting;
	private Date end;	// DURATION.TYPE muss auf DAY stehen
	private Renewal renewal = Renewal.NO_RENEWAL;
	private String renewalsInfo;

	// Nr. 10. Angaben über Varianten/Alternativangebote
	private Variants variants = Variants.NO_ACCEPTED_VARIANTS;

	/**
	 * 
	 */
	public ObjectDescriptionF01F02F05() {
	}

	/**
	 * @return the valueExclVat
	 */
	@Mapping("VALOBJECT")
	@TedRequired
	public Val getValObject() {
		return valObject;
	}

	/**
	 * @param valueExclVat the valueExclVat to set
	 */
	public void setValObject(Val valObjectt) {
		this.valObject = valObjectt;
	}

	/**
	 * @return the duration
	 */
	public Duration getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	@Mapping("DURATION.TYPE")
	public String getDurationType() {
		return getDurationMonth() != null ? "MONTH" : (getIndays() != null ? "DAY" : null);
	}

	/**
	 * @return the durationMonth
	 */
	@Mapping("DURATION.Value")
	public BigInteger getDurationMonth() {
		return durationMonth;
	}

	/**
	 * @param durationMonth the durationMonth to set
	 */
	public void setDurationMonth(BigInteger durationMonth) {
		this.durationMonth = durationMonth;
	}

	/**
	 * @return the indays
	 */
	@Mapping("DURATION.Value")
	public BigInteger getIndays() {
		return indays;
	}

	/**
	 * @param indays the indays to set
	 */
	public void setIndays(BigInteger indays) {
		this.indays = indays;
	}

	/**
	 * @return the starting
	 */
	@Mapping("DATESTART")
	public Date getStarting() {
		return starting;
	}

	/**
	 * @param starting the starting to set
	 */
	public void setStarting(Date starting) {
		this.starting = starting;
	}

	/**
	 * @return the end
	 */
	@Mapping("DATEEND")
	public Date getEnd() {
		return end;
	}

	/**
	 * @param end the end to set
	 */
	public void setEnd(Date end) {
		this.end = end;
	}

	/**
	 * @return the renewalsSubject
	 */
	@Mapping("")
	public Renewal getRenewal() {
		return renewal;
	}

	/**
	 * @param renewal the renewalsSubject to set
	 */
	public void setRenewal(Renewal renewal) {
		this.renewal = renewal;
	}

	/**
	 * @return the renewalsInfo
	 */
	@Mapping("RENEWALDESCR")
	@TedMaxLength(400)
	public String getRenewalsInfo() {
		return renewalsInfo;
	}

	/**
	 * @param renewalsInfo the renewalsInfo to set
	 */
	public void setRenewalsInfo(String renewalsInfo) {
		this.renewalsInfo = renewalsInfo;
	}

	/**
	 * @return the variantsAccepted
	 */
	@Mapping("")
	public Variants getVariants() {
		return variants;
	}

	/**
	 * @param variants the variantsAccepted to set
	 */
	public void setVariants(Variants variants) {
		this.variants = variants;
	}

}
