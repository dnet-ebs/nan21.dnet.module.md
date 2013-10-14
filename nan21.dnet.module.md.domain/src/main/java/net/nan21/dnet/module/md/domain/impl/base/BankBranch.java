/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.domain.impl.base;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import net.nan21.dnet.core.domain.impl.AbstractTypeWithCode;
import net.nan21.dnet.module.md.domain.impl.base.Bank;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 * Bank branch definitions.
 */
@NamedQueries({
		@NamedQuery(name = BankBranch.NQ_FIND_BY_CODE, query = "SELECT e FROM BankBranch e WHERE e.clientId = :clientId and e.bank = :bank and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = BankBranch.NQ_FIND_BY_CODE_PRIMITIVE, query = "SELECT e FROM BankBranch e WHERE e.clientId = :clientId and e.bank.id = :bankId and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = BankBranch.NQ_FIND_BY_NAME, query = "SELECT e FROM BankBranch e WHERE e.clientId = :clientId and e.bank = :bank and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = BankBranch.NQ_FIND_BY_NAME_PRIMITIVE, query = "SELECT e FROM BankBranch e WHERE e.clientId = :clientId and e.bank.id = :bankId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = BankBranch.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = BankBranch.TABLE_NAME + "_UK1", columnNames = {
				"CLIENTID", "BANK_ID", "CODE"}),
		@UniqueConstraint(name = BankBranch.TABLE_NAME + "_UK2", columnNames = {
				"CLIENTID", "BANK_ID", "NAME"})})
public class BankBranch extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "MD_BANK_BRANCH";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "BankBranch.findByCode";
	/**
	 * Named query find by unique key: Code using the ID field for references.
	 */
	public static final String NQ_FIND_BY_CODE_PRIMITIVE = "BankBranch.findByCode_PRIMITIVE";
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "BankBranch.findByName";
	/**
	 * Named query find by unique key: Name using the ID field for references.
	 */
	public static final String NQ_FIND_BY_NAME_PRIMITIVE = "BankBranch.findByName_PRIMITIVE";

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Bank.class)
	@JoinColumn(name = "BANK_ID", referencedColumnName = "ID")
	private Bank bank;

	public Bank getBank() {
		return this.bank;
	}

	public void setBank(Bank bank) {
		if (bank != null) {
			this.__validate_client_context__(bank.getClientId());
		}
		this.bank = bank;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
