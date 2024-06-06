package com.oderzy._data_.helper;

import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.jdbc.object.BatchSqlUpdate;
import org.springframework.stereotype.Service;

import com.oderzy._data_.model.CustomerCode;

@Service
public class CustomerCodeBuilders {

	private static final String uniqueCodeForYear = "ac4To ac4T6 ac4Tp ac4T8 ac4TU ac4Td ac4T7 ac4TB ac4T5 ac4TX ac4T9 ac4o6 ac4op ac4o8 ac4oU ac4od ac4o7 ac4oB aco7X aco79 acoB5 acoBX acoB9 aco5X aco59 acoX9 ac6p8 ac6pU ac6pd ac6p7 ac6pB ac6p5 ac6pX ac6p9 ac68U ac68d ac687 ac68B ac685 ac68X ac689 ac6Ud ac6U7 ac6UB ac6U5 ac6UX ac6U9 ac6d7 ac6dB ac6d5 ac6dX ac6d9 ac67B ac675 a87BX a87B9 a875X a8759 a87X9 a8B5X a8B59 a8BX9 a85X9 aUd7B aUd75 aUd7X aUd79 aUdB5 aUdBX aUdB9 aUd5X aUd59 aUdX9 aU7B5 aU7BX aU7B9 aU75X aU759 aU7X9 aUB5X aUB59 aUBX9 aU5X9 ad7B5 ad7BX ad7B9 ad75X ad759 ad7X9 adB5X adB59 adBX9 ad5X9 a7B5X a7B59 a7BX9 a75X9 aB5X9 c4To6 c4Top c4To8 c4ToU c4Tod c4To7 c4ToB c4To5 c4ToX c4To9 c4T6p c4T68 c4T6U c4T6d c4T67 c4T6B c4T65 c4T6X c4T69 c4Tp8 c4TpU c4Tpd c4Tp7 c4TpB c4Tp5 c4TpX c4Tp9 c4T8U c4T8d c4T87 c4T8B c4T85 c4T8X c4T89 c4TUd c4TU7 c4TUB c4TU5 c4TUX c4TU9 c4Td7 c48dX c48d9 c487B c4875 c487X c4879 c48B5 c48BX c48B9 c485X c4859 c48X9 c4Ud7 c4UdB c4Ud5 c4UdX c4Ud9 c4U7B c4U75 c4U7X c4U79 c4UB5 c4UBX c4UB9 c4U5X c4U59 c4UX9 c4d7B c4d75 c4d7X c4d79 c4dB5 c4dBX c4dB9 cTp8X cTp89 cTpUd cTpU7 cTpUB cTpU5 cTpUX cTpU9 cTpd7 cTpdB cTpd5 cTpdX cTpd9 cTp7B cTp75 cTp7X cTp79 cTpB5 cTpBX cTpB9 cTp5X cTp59 cTpX9 cT8Ud cT8U7 cT8UB cT8U5 cT8UX cT8U9 cT8d7 cT8dB cT8d5 cT8dX cT8d9 cT87B cT875 cT87X cT879 cT8B5 cT8BX cT8B9 cT85X cT859 cT8X9 cTUd7 cTUdB cTUd5 cTUdX cTUd9 cTU7B cTU75 cTU7X cTU79 cTUB5 cTUBX cTUB9 cTU5X cTU59 cTUX9 cTd7B cTd75 cTd7X cTd79 cTdB5 cTdBX cTdB9 cTd5X cTd59 cTdX9 cT7B5 cT7BX cT7B9 cT75X cT759 cT7X9 cTB5X cTB59 cTBX9 cT5X9 co6p8 co6pU co6pd co6p7 co6pB co6p5 c6Ud9 c6U7B c6U75 c6U7X c6U79 c6UB5 c6UBX c6UB9 c6U5X c6U59 c6UX9 c6d7B c6d75 c6d7X 4T8UB 4T8U5 4T8UX 4T8U9 4T8d7 4T8dB 4T8d5 4T8dX 4T8d9 4T87B 4T875 4T87X 4T879 4T8B5 4T8BX 4T8B9 4T85X 4T859 4T8X9 4TUd7 4TUdB 4TUd5 4TUdX 4TUd9 4TU7B 4TU75 4TU7X 4TU79 4TUB5 4TUBX 4TUB9 4TU5X 4TU59 4TUX9 4Td7B 4Td75 4Td7X 4Td79 4TdB5 4TdBX 4TdB9 4Td5X 4Td59 4TdX9 4T7B5 4T7BX 4T7B9 4T75X 4T759 4T7X9 4TB5X 4TB59 4TBX9 46pUB 46pU5 46pUX 46pU9 46pd7 46pdB 46pd5 46pdX 46pd9 46p7B 46p75 46p7X 46p79 46pB5 46pBX 46pB9 46p5X 46p59 46pX9 468Ud 468U7 468UB 468U5 468UX 468U9 468d7 468dB 468d5 468dX 468d9 4687B 46875 4687X 46879 468B5 468BX 468B9 4685X 46859 468X9 46Ud7 46UdB 46Ud5 46UdX 46Ud9 46U7B 46U75 46U7X 46U79 46UB5 46UBX 46UB9 46U5X 46U59 46UX9 46d7B 46d75 46d7X 46d79 46dB5 46dBX 46dB9 46d5X 46d59 46dX9 467B5 467BX 467B9 4675X 46759 467X9 46B5X 46B59 46BX9 465X9 4p8Ud 4p8U7 4p8UB 4p8U5 4p8UX 4p8U9 4p8d7 4p8dB 4p8d5 4p8dX 4p8d9 4p87B 4p875 4p87X 4p879 4p8B5 4p8BX 4p8B9 4p85X 4p859 4p8X9 4pUd7 4pUdB 4pUd5 4pUdX 4pUd9 4pU7B 4pU75 4pU7X 4pU79 4pUB5 4pUBX 4pUB9 4pU5X 4pU59 4pUX9 4pd7B 4pd75 4pd7X 4pd79 4pdB5 4pdBX 4pdB9 ToUB9 ToU5X ToU59 ToUX9 Tod7B Tod75 Tod7X Tod79 TodB5 TodBX TodB9 Tod5X Tod59 TodX9 To7B5 To7BX To7B9 To75X To759 To7X9 ToB5X ToB59 ToBX9 To5X9 T6p8U T6p8d T6p87 T6p8B T6p85 T6p8X T6p89 T6pUd T6pU7 T6pUB T6pU5 T6pUX T6pU9 T6pd7 T6pdB T6pd5 T6pdX T6pd9 T6p7B T6p75 T6p7X T6p79 T6pB5 T6pBX T6pB9 T6p5X T6p59 T6pX9 T68Ud T68U7 T68UB T68U5 T68UX T68U9 T68d7 T68dB T68d5 T68dX T68d9 T687B T6875 T687X T6879 T68B5 T68BX T68B9 T685X T6859 T68X9 T6Ud7 T6UdB T6Ud5 T6UdX T6Ud9 T6U7B T6U75 T6U7X T6U79 T6UB5 T6UBX T6UB9 T6U5X T6U59 T6UX9 T6d7B T6d75 T6d7X T6d79 T6dB5 T6dBX T6dB9 T6d5X T6d59 T6dX9 T67B5 T67BX T67B9 T675X T6759 T67X9 T6B5X T6B59 T6BX9 T65X9 Tp8Ud Tp8U7 Tp8UB Tp8U5 Tp8UX Tp8U9 Tp8d7 Tp8dB Tp8d5 Tp8dX Tp8d9 Tp87B Tp875 Tp87X Tp879 Tp8B5 Tp8BX Tp8B9 Tp85X Tp859 Tp8X9 TpUd7 TpUdB TpUd5 TpUdX TpUd9 TpU7B TpU75 TpU7X TpU79 TpUB5 TpUBX TpUB9 TpU5X TpU59 TpUX9 Tpd7B Tpd75 Tpd7X Tpd79 TpdB5 TpdBX TpdB9 Tpd5X Tpd59 TpdX9 Tp7B5 Tp7BX Tp7B9 Tp75X Tp759 Tp7X9 TpB5X TpB59 TpBX9 Tp5X9 T8Ud7 T8UdB T8Ud5 T8UdX T8Ud9 T8U7B T8U75 T8U7X T8U79 T8UB5 T8UBX T8UB9 T8U5X T8U59 T8UX9 T8d7B T8d75 T8d7X T8d79 T8dB5 T8dBX T8dB9 T8d5X T8d59 T8dX9 T87B5 T87BX T87B9 T875X T8759 T87X9 T8B5X T8B59 T8BX9 T85X9 TUd7B TUd75 TUd7X TUd79 TUdB5 TUdBX TUdB9 TUd5X TUd59 TUdX9 TU7B5 TU7BX TU7B9 TU75X TU759 TU7X9 TUB5X TUB59 TUBX9 TU5X9 Td7B5 Td7BX Td7B9 Td75X Td759 Td7X9 TdB5X TdB59 TdBX9 Td5X9 T7B5X T7B59 T7BX9 T75X9 TB5X9 o6p8U o6p8d o6p87 o6p8B o6p85 o6p8X o6p89 o6pUd o6pU7 o6pUB o6pU5 o6pUX o6pU9 o6pd7 o6pdB o6pd5 8U7B9 8U75X 8U759 8U7X9 8UB5X 8UB59 8UBX9 8U5X9 8d7B5 8d7BX 8d7B9 8d75X 8d759 8d7X9 8dB5X 8dB59 8dBX9 8d5X9 87B5X 87B59 87BX9 875X9 8B5X9 Ud7B5 Ud7BX Ud7B9 Ud75X Ud759 Ud7X9 UdB5X UdB59 UdBX9 Ud5X9 U7B5X U7B59 U7BX9 U75X9 UB5X9 d7B5X d7B59 d7BX9 d75X9 dB5X9 7B5X9";
		@Autowired
	private DataSource dataSource;

	private BatchSqlUpdate insertSql;

	public CustomerCodeBuilders() {

	}

	public void reCreateUniqueCustomerCodeForCurrentYear() {
		System.out.println("Customer code generating");
		List<String> uniqueCodeForYearList = new ArrayList<String>(Arrays.asList(uniqueCodeForYear.split(" ")));

		insertSql = new BatchSqlUpdate();
		insertSql.setDataSource(dataSource);
		insertSql.setSql("insert into customer_code (code, date) values ( ?, ?)");
		insertSql.declareParameter(new SqlParameterValue(Types.VARCHAR, "code"));
		insertSql.declareParameter(new SqlParameterValue(Types.DATE, "date"));

		this.addToDB(uniqueCodeForYearList);

	}

	private void addToDB(List<String> data) {
		LocalDate[] future = { LocalDate.now() };
		List<CustomerCode> icLIST = new ArrayList<CustomerCode>();
		data.forEach(d -> {
			insertSql.update(d, future[0]);
			icLIST.add(new CustomerCode(d, future[0]));
			future[0] = future[0].plusDays(1);
		});
		insertSql.flush();
		insertSql.reset();
	}
	public List<CustomerCode> gene() {
		List<String> data = new ArrayList<String>(Arrays.asList(uniqueCodeForYear.split(",")));

		LocalDate[] future = { LocalDate.now() };
		List<CustomerCode> icLIST = new ArrayList<CustomerCode>();
		data.forEach(d -> {
			icLIST.add(new CustomerCode(d, future[0]));
			future[0] = future[0].plusDays(1);
		});
		return icLIST;
	}
}
