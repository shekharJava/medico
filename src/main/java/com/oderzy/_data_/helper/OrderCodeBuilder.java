package com.oderzy._data_.helper;

import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.jdbc.object.BatchSqlUpdate;
import org.springframework.stereotype.Service;

import com.oderzy._data_.model.OrderCode;

@Service
public class OrderCodeBuilder {

	private static final String uniqueCodeForYear = "AA AB AC AD AE AF AH AI AJ AL AN AO AP AQ AU AV AW AX AY AZ BA BB BC BD BE BF BH BI BJ BL BN BO BP BQ BU BV BW BX BY BZ CA CB CC CD CE CF CH CI CJ CL CN CO CP CQ CU CV CW CX CY CZ DA DB DC DD DE DF DH DI DJ DL DN DO DP DQ DU DV DW DX DY DZ EA EB EC ED EE EF EH EI EJ EL EN EO EP EQ EU EV EW EX EY EZ FA FB FC FD FE FF FH FI FJ FL FN FO FP FQ FU FV FW FX FY FZ HA HB HC HD HE HF HH HI HJ HL HN HO HP HQ HU HV HW HX HY HZ IA IB IC ID IE IF IH II IJ IL IN IO IP IQ IU IV IW IX IY IZ JA JB JC JD JE JF JH JI JJ JL JN JO JP JQ JU JV JW JX JY JZ LA LB LC LD LE LF LH LI LJ LL LN LO LP LQ LU LV LW LX LY LZ NA NB NC ND NE NF NH NI NJ NL NN NO NP NQ NU NV NW NX NY NZ OA OB OC OD OE OF OH OI OJ OL ON OO OP OQ OU OV OW OX OY OZ PA PB PC PD PE PF PH PI PJ PL PN PO PP PQ PU PV PW PX PY PZ QA QB QC QD QE QF QH QI QJ QL QN QO QP QQ QU QV QW QX QY QZ UA UB UC UD UE UF UH UI UJ UL UN UO UP UQ UU UV UW UX UY UZ VA VB VC VD VE VF VH VI VJ VL VN VO VP VQ VU VV VW VX VY VZ WA WB WC WD WE WF WH WI WJ WL WN WO WP WQ WU WV WW WX WY WZ XA XB XC XD XE XF XH XI XJ XL XN XO XP XQ XU XV XW XX XY XZ YA YB YC YD YE YF YH YI YJ YL YN YO YP YQ YU YV YW YX YY YZ ZA ZB ZC ZD ZE ZF ZH ZI ZJ ZL ZN ZO ZP ZQ ZU ZV ZW ZX ZY ZZ";
	//private static final String uniqueCodeForYear = "HNXY,LUWY,DFUW,DJVY,NPUX,HLNZ,BCFW,BFNX,EJUZ,DJWX,EPVY,BPUW,ACHX,BCHJ,ADUY,ACLU,BLPZ,NUVY,ENUY,BPVY,FLWZ,CDFV,HPUZ,ADEX,CLNU,NUWX,EUWZ,ABCU,DFJV,CFJX,AHPU,AFYZ,ACXZ,CWXY,BELU,HVWZ,DVWX,AFJL,DFPW,JLWX,DLNU,AJYZ,DFLZ,CEXZ,AJXZ,ADLZ,FNPY,CFJV,JNWZ,ADFU,DJLP,NPWY,ADHP,CDWX,HLXZ,EFLX,DPYZ,AFWZ,FVXZ,CFHV,ACVX,BCFJ,ENUX,ENWX,CFJP,AHJZ,DHWX,BEFU,BCJZ,EFJX,CDNV,ABWZ,BENZ,BCDH,BCPU,ACUW,CJUW,ABEJ,BUWY,DEXZ,DFHJ,EJWY,BEHU,EFUY,BNWY,BNWZ,CEWX,DHNZ,EPWZ,BHUZ,AFVX,BCDL,BCLZ,LVYZ,DEHY,NUXY,HNWX,LNUZ,FHNX,PWYZ,ALXY,FJXZ,FLUX,CNPV,DHUX,BFHU,HJNZ,CHLV,BJYZ,BWXZ,AHNU,BPUX,BUVW,BHJV,BCPW,EWXY,AEHX,BJLY,ADPW,DUVW,EVXZ,DJPX,ENUZ,BJPY,EUVW,DJUX,BHLV,CFPX,CEFN,ABUX,CLVW,CUXZ,JLNZ,CNYZ,FLYZ,DNPZ,BNPY,CEPV,CLUW,JPWY,FHJU,EJNY,NPVW,ANUZ,ELPX,WXYZ,FNWZ,FJLW,DLWZ,BPWY,DFHL,CHNV,BHJL,BCNZ,HPUW,CHWX,DJUY,ACDY,LVXY,CFPW,EVXY,NPXZ,EFHL,ACEN,BFLY,BDEU,CWXZ,JWXZ,BCFL,AJPW,JNYZ,JNUX,CEJW,DLNV,EFLV,BJLZ,BELX,ADLW,ACDP,ACEL,DEWY,CDNU,JLNP,BFHW,CHVX,LPUY,BDNW,ABXY,BCHW,CEPU,EHWY,ADHJ,HLNU,BCHX,BPWZ,JNPV,CDEN,FNXZ,AUXZ,BJWX,HJNV,CHNP,DJLN,BDEF,AFPZ,ANXY,JUXZ,ADUW,CDPW,EFWX,EPUV,ENVX,EHUX,CPVX,ELXZ,BHUV,CFJN,FHJN,FNUZ,ABJW,BDEY,APUW,EFJY,DEXY,BHPW,AHJL,BHJZ,FNVZ,BJUX,AEHV,EHPV,CEUX,HUWX,DEJU,CDEP,BFWX,ALNV,PUVY,DLXZ,CDLN,ELVZ,BEHN,FPXZ,JNPZ,AFNW,BDNX,BCDV,EFPZ,ABUW,AFHX,CNUX,FJPV,JNVX,ABCX,FJWZ,AFJY,FUVW,FJUX,EJPZ,AENV,AEPY,CEPW,JLPV,BLNZ,BEHX,CEFL,DEJP,ABNW,AELV,CDEU,HJPU,CNPX,ACFJ,ACHV,CDEY,BPVZ,AEVY,ALNZ,ACDX,FHXY,ACEH,FJLU,BHVZ,CHJZ,FVWZ,HNPY,BDEN,HLUZ,LXYZ,BDHL,BJUY,AEJL,AFPX,EHJX,HJPW,ADLN,BCJY,DHWY,HPVY,CFVZ,JNVW,EJLZ,BHPZ,CHNZ,EFJP,JXYZ,HUVW,CENV,DFXZ,CVWX,CJNY,DNPU,NPUW,NWXY,DJUW,ADJU,FLVX,DEFN,HJLV,DJVX,EFJZ,BCEL,CPWZ,FLNP,DHJN,BVWZ,AELN,NVYZ,ABHW,ANUW,CFYZ,DEFL,DNUX,DFPZ,EHPW,EVWZ,FUWZ,ABVW,AVWX,AEPX,BNXY,HLNY,EHJW,ACEZ,BHLX,FLPV,ABHJ,CDYZ,ELXY,ABCF,LUVX,BCJN,AFJW,DELX,BJUV,HJYZ,ACVZ,JPUY,CDLV,ENPU,CLYZ,ADEL,BHJU,BELZ,ABDZ,HJLP,FUXZ,FPUV,HJPY,FUWY,BCEX,BPXY,HLVZ,BCFP,ABHN,DUVX,HNUV,CHVZ,BLUX,DPVW,CFLY,EUWY,BDHJ,CNWZ,AEFY,FHUX,BCDW,ABEP,LNPV,CENZ,NPYZ,CFJU,BDFZ,FJNX,BJLV,ACDH,BDJY,CFUY,DEFJ,BDFW,AHUY";
	//private static final String uniqueCodeForYear = "8aad aadp aadz Taad aadw aadn PPaa LPaa 2Paa Paae MPaa EPaa Paaf PSaa 4Paa Paag PRaa BPaa 5Paa Paah 6Paa PVaa CPaa PXaa 7Paa 8Paa Paap Paaz PTaa Paaw Paan LLaa 2Laa Laae LMaa ELaa Laaf LSaa 4Laa Laag LRaa BLaa 5Laa Laah 6Laa LVaa CLaa LXaa 7Laa 8Laa Laap Laaz LTaa Laaw Laan 22aa 2aae 2Maa 2Eaa 2aaf 2Saa 24aa 2aag 2Raa 2Baa 25aa 2aah 26aa 2Vaa 2Caa 2Xaa 27aa 28aa 2aap 2aaz 2Taa 2aaw 2aan aaee Maae Eaae aaef Saae 4aae aaeg Raae Baae 5aae aaeh 6aae Vaae Caae Xaae 7aae 8aae aaep aaez Taae aaew aaen MMaa EMaa Maaf MSaa 4Maa Maag MRaa BMaa 5Maa Maah 6Maa MVaa CMaa MXaa 7Maa 8Maa Maap Maaz MTaa Maaw Maan EEaa Eaaf ESaa 4Eaa Eaag ERaa BEaa 5Eaa Eaah 6Eaa EVaa CEaa EXaa 7Eaa 8Eaa Eaap Eaaz ETaa Eaaw Eaan aaff Saaf 4aaf aafg Raaf Baaf 5aaf aafh 6aaf Vaaf Caaf Xaaf 7aaf 8aaf aafp aafz Taaf aafw aafn SSaa 4Saa Saag RSaa BSaa 5Saa Saah 6Saa SVaa CSaa SXaa 7Saa 8Saa Saap Saaz STaa Saaw Saan 44aa 4aag 4Raa 4Baa 45aa 4aah 46aa 4Vaa 4Caa 4Xaa 47aa 48aa 4aap 4aaz 4Taa 4aaw 4aan aagg Raag Baag 5aag aagh 6aag Vaag Caag Xaag 7aag 8aag aagp aagz Taag aagw aagn RRaa BRaa 5Raa Raah 6Raa RVaa CRaa RXaa 7Raa 8Raa Raap Raaz RTaa Raaw Raan BBaa 5Baa Baah 6Baa BVaa BCaa BXaa 7Baa 8Baa Baap Baaz BTaa Baaw Baan 55aa 5aah 56aa 5Vaa 5Caa 5Xaa 57aa 58aa 5aap 5aaz 5Taa 5aaw 5aan aahh 6aah Vaah Caah Xaah 7aah 8aah aahp aahz Taah aahw aahn 66aa 6Vaa 6Caa 6Xaa 67aa 68aa 6aap 6aaz 6Taa 6aaw 6aan VVaa CVaa VXaa 7Vaa 8Vaa Vaap Vaaz TVaa Vaaw Vaan CCaa CXaa 7Caa 8Caa Caap Caaz CTaa Caaw Caan XXaa 7Xaa 8Xaa Xaap Xaaz TXaa Xaaw Xaan 77aa 78aa 7aap 7aaz 7Taa 7aaw 7aan 88aa 8aap 8aaz 8Taa 8aaw 8aan aapp aapz Taap aapw aanp aazz Taaz aawz aanz TTaa Taaw Taan aaww aanw aann QQQa 9QQa HQQa QQab DQQa QQYa 1QQa QQac KQQa QQad PQQa LQQa 2QQa QQae MQQa EQQa QQaf QQSa 4QQa QQag QQRa BQQa 5QQa QQah 6QQa QQVa CQQa QQXa 7QQa 8QQa QQap QQaz QQTa QQaw QQan 99Qa 9HQa 9Qab 9DQa 9QYa 19Qa 9Qac 9KQa 9Qad 9PQa 9LQa 29Qa 9Qae 9MQa 9EQa 9Qaf 9QSa 49Qa 9Qag 9QRa 9BQa 59Qa 9Qah 69Qa 9QVa 9CQa 9QXa 79Qa 89Qa 9Qap 9Qaz 9QTa 9Qaw 9Qan HHQa HQab DHQa HQYa 1HQa HQac HKQa HQad HPQa HLQa 2HQa HQae HMQa EHQa HQaf HQSa 4HQa HQag HQRa BHQa 5HQa HQah 6HQa HQVa CHQa HQXa 7HQa 8HQa HQap HQaz HQTa HQaw HQan Qabb DQab QYab 1Qab Qabc KQab Qabd PQab LQab 2Qab Qabe MQab EQab Qabf QSab 4Qab Qabg QRab BQab 5Qab Qabh 6Qab QVab CQab QXab 7Qab 8Qab Qabp Qabz QTab Qabw Qabn DDQa DQYa 1DQa DQac DKQa DQad DPQa DLQa 2DQa DQae DMQa DEQa DQaf DQSa 4DQa ";


	@Autowired
	private DataSource dataSource;

	private BatchSqlUpdate insertSql;

	public void reCreateUniqueOrderCodeForCurrentYear() {
		System.out.println("order code generating");

		insertSql = new BatchSqlUpdate();
		insertSql.setDataSource(dataSource);
		insertSql.setSql("insert into order_code (code, date) values ( ?, ?)");
		insertSql.declareParameter(new SqlParameterValue(Types.VARCHAR, "code"));
		insertSql.declareParameter(new SqlParameterValue(Types.DATE, "date"));

		List<String> uniqueCodeForYearList = new ArrayList<String>(Arrays.asList(uniqueCodeForYear.split(" ")));
		Collections.shuffle(uniqueCodeForYearList);
		this.addToDB(uniqueCodeForYearList);
	}

	private void addToDB(List<String> data) {
		LocalDate[] future = { LocalDate.now() };
		data.forEach(d -> {
			insertSql.update(d, future[0]);
			future[0] = future[0].plusDays(1);
		});
		insertSql.flush();
		insertSql.reset();
	}

	public List<OrderCode> gene() {
		List<String> data = new ArrayList<String>(Arrays.asList(uniqueCodeForYear.split(" ")));
		Collections.shuffle(data);
		LocalDate[] future = { LocalDate.now() };
		List<OrderCode> icLIST = new ArrayList<OrderCode>();
		data.forEach(d -> {
			icLIST.add(new OrderCode(d, future[0]));
			future[0] = future[0].plusDays(1);
		});
		return icLIST;
	}
}
