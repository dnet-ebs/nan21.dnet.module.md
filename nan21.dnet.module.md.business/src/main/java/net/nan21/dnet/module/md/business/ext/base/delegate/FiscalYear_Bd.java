package net.nan21.dnet.module.md.business.ext.base.delegate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.md.domain.impl.base.FiscalPeriod;
import net.nan21.dnet.module.md.domain.impl.base.FiscalYear;

public class FiscalYear_Bd extends AbstractBusinessDelegate {
	/**
	 * Create monthly periods for the given fiscal year.
	 * 
	 * @param year
	 * @throws BusinessException
	 */
	public void createMonths(FiscalYear year) throws BusinessException {
		Date start = year.getStartDate();
		Date end = year.getEndDate();

		DateTime first = new DateTime(start).dayOfMonth().withMinimumValue();
		DateTime last = new DateTime(end).dayOfMonth().withMaximumValue();
		DateTime current = first;

		List<FiscalPeriod> periods = new ArrayList<FiscalPeriod>();
		while (current.isBefore(last)) {

			DateTime periodStart = current.dayOfMonth().withMinimumValue();
			DateTime periodEnd = current.dayOfMonth().withMaximumValue();

			FiscalPeriod p = new FiscalPeriod();

			String name = year.getName() + "-"
					+ periodStart.monthOfYear().getAsShortText();
			// periodStart.getMonthOfYear();

			p.setType("month");
			p.setStartDate(periodStart.toDate());
			p.setEndDate(periodEnd.toDate());
			p.setPosting(true);
			p.setName(name);
			p.setFiscalYear(year);
			periods.add(p);

			DateTime next = current.plusMonths(1);
			current = next;
		}

		this.findEntityService(FiscalPeriod.class).insert(periods);

	}

	/**
	 * Create quarter periods for the given fiscal year.
	 * 
	 * @param year
	 * @throws BusinessException
	 */
	public void createQuarters(FiscalYear year) throws BusinessException {
		Date start = year.getStartDate();
		Date end = year.getEndDate();

		DateTime first = new DateTime(start).dayOfMonth().withMinimumValue();
		DateTime last = new DateTime(end).dayOfMonth().withMaximumValue();
		DateTime current = first;

		List<FiscalPeriod> periods = new ArrayList<FiscalPeriod>();
		int x = 0;
		while (current.isBefore(last)) {
			x++;
			DateTime periodStart = current.dayOfMonth().withMinimumValue();
			DateTime periodEnd = current.plusMonths(2).dayOfMonth()
					.withMaximumValue();

			FiscalPeriod p = new FiscalPeriod();
			String name = year.getName() + "-Q" + x;

			p.setType("quarter");
			p.setStartDate(periodStart.toDate());
			p.setEndDate(periodEnd.toDate());

			p.setName(name);
			p.setFiscalYear(year);
			periods.add(p);

			DateTime next = current.plusMonths(3);
			current = next;
		}

		this.findEntityService(FiscalPeriod.class).insert(periods);
	}

	/**
	 * Create half year periods for the given fiscal year.
	 * 
	 * @param year
	 * @throws BusinessException
	 */
	public void createHalfYears(FiscalYear year) throws BusinessException {
		Date start = year.getStartDate();
		Date end = year.getEndDate();

		DateTime first = new DateTime(start).dayOfMonth().withMinimumValue();
		DateTime last = new DateTime(end).dayOfMonth().withMaximumValue();
		DateTime current = first;

		List<FiscalPeriod> periods = new ArrayList<FiscalPeriod>();
		int x = 0;
		while (current.isBefore(last)) {
			x++;
			DateTime periodStart = current.dayOfMonth().withMinimumValue();
			DateTime periodEnd = current.plusMonths(5).dayOfMonth()
					.withMaximumValue();

			FiscalPeriod p = new FiscalPeriod();

			String name = year.getName() + "-H" + x;

			p.setType("half-year");
			p.setStartDate(periodStart.toDate());
			p.setEndDate(periodEnd.toDate());

			p.setName(name);
			p.setFiscalYear(year);
			periods.add(p);

			DateTime next = current.plusMonths(6);
			current = next;
		}

		this.findEntityService(FiscalPeriod.class).insert(periods);

	}
}
