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

import com.oderzy._data_.model.CartCode;

@Service
public class CartCodeBuilder {
	private static final String uniqueCodeForYear ="Sac SaT Sao Sap coY con coq coZ cor cpU cpd cpg cpV cph cpk cpW cpl cpm cpX cpb cpY cpn cpq cpZ cpr cUd cUg cUV cUh cUk SaU Sad Scd Scg ScV Sch Sck ScW Scl Scm ScX Scb ScY Scn Scq ScZ Scr STo STp STU STd STg STV STh SpX Sdk SVW SVl SVm SVX SVb SVY SVn SVq SVZ SVr Shk ShW Shl Shm ShX Shb ShY Shn Shq ShZ Shr SkW Skl Skm SkX Skb SkY Skn Skq SkZ Skr SWl SWm SWX SWb SWY SWn SWq SWZ SWr Slm SlX Slb SlY Sln Slq SlZ Slr SmX Smb SmY Smn acp acU acd acg acV ach ack acW acl acm acX acb acY acn acq acZ acr aTo aTp aTU aTd aTg aTV aTh aTk aTW aTl aTm aTX aTb aTY aTn aTq aTZ aTr aop aoU aod aog aoV aoh aok aoW aol aom aoX aob aoY aon aoq aoZ aor apU apd apg apV aph apk apW apl apm apX apb apY apn apq apZ apr aUd aUg aUV aUh aUk aUW aUl aUm aUX aUb TUW TUl TUm TUX TUb TUY TUn TUq TUZ TUr Tdg TdV Tdh Tdk TdW Tdl Tdm TdX Tdb TdY Tdn Tdq TdZ Tdr TgV Tgh Tgk TgW Tgl Tgm TgX Tgb TgY Tgn Tgq TgZ Tkl Tkm TkX Tkb TkY Tkn Tkq TkZ Tkr TWl TWm TWX TWb TWY TWn TWq TWZ TWr Tlm TlX Tlb TlY Tln Tlq TlZ Tlr TmX Tmb TmY Tmn Tmq TmZ Tmr TXb TXY TXn TXq TXZ TXr TbY Tbn Tbq TbZ Tbr TYn TYq TYZ TYr Tnq TnZ Tnr TqZ Tqr TZr opU opd opg opV oph opk opW opl opm opX opb opY opn opq opZ opr oUd oUg oUV oUh oUk oUW oUl oUm oUX oUb oUY oUn oUq oUZ oUr odg odV odh odk odW odl odm odX odb odY odn odq odZ odr ogV ogh ogk ohl ohm ohX ohb ohY ohn ohq ohZ ohr okW okl okm okX okb okY okn okq okZ okr oWl oWm oWX oWb oWY oWn oWq oWZ oWr olm olX olb olY oln olq olZ olr omX omb omY omn omq omZ omr oXb oXY oXn oXq oXZ oXr obY obn obq obZ obr oYn oYq oYZ oYr onq onZ onr oqZ oqr oZr pUd pUg pUV pUh pUk pUW pUl pUm pUX pUb pUY pUn pUq pgn pgq pgZ pgr pVh pVk pVW pVl pVm pVX pVb pVY pVn pVq pVZ pVr phk phW phl phm phX phb phY phn phq phZ phr pkW pkl pkm pkX pkb pkY pkn pkq pkZ pkr pWl pWm pWX pWb pWY pWn pWq pWZ pWr plm plX plb plY pYr pnq pnZ pnr pqZ pqr pZr Udg UdV Udh Udk UdW Udl Udm UdX Udb UdY Udn Udq UdZ Udr UgV Ugh Ugk UgW Ugl Ugm UgX Ugb UgY Ugn Ugq UgZ Ugr UVh UVk UVW UVl UVm dnq dnZ dnr dqZ dqr dZr gVh gVk gVW gVl gVm gVX gVb gVY gVn gVq gVZ gVr ghk ghW ghl ghm ghX ghb ghY ghn ghq ghZ ghr gkW gkl gWr glm glX glb glY gln glq glZ glr gnr gqZ gqr gZr Vhk VhW Vhl Vhm VhX Vhb VhY Vhn Vhq VhZ Vhr VkW Vkl Vkm VkX Vkb VkY Vkn Vkq VkZ Vkr VWl VWm VWX VWb VWY VYr Vnq VnZ Vnr VqZ Vqr VZr hkW hkl hkm hkX hkb hkY hkn hkq hkZ hkr hWl hWm hWX hWb hWY hWn hWq hWZ hbZ hbr hYn hYq hYZ hYr hnq hnZ hnr hqZ hqr hZr kWl kWm kWX kWb kWY kWn kWq kWZ kWr klm klX klb klY kln klq klZ klr kmX kmb kmY kmn kmq kmZ kmr kXb kXY kXn kXq kXZ kXr kbY kbn kbq kbZ kbr kYn kYq kYZ kYr knq knZ knr kqZ kqr kZr Wlm WlX Wlb WlY Wln Wlq WlZ Wlr WmX Wmb WmY Wmn Wmq WmZ Wmr WXb WXY WXn WXq WXZ WXr WbY Wbn Wbq WbZ Wbr WYn WYq WYZ WYr Wnq WnZ Wnr WqZ Wqr WZr lmX lmb lmY lmn lmq lmZ lmr lXb lXY lXn lXq lXZ lXr lbY lbn lbq lbZ lbr lYn lYq lYZ lYr lnq lnZ lnr lqZ lqr lZr mXb mXY mXn mXq mXZ mXr mbY mbn mbq mbZ mbr mYn mYq mYZ mYr mnq mnZ mnr mqZ mqr mZr XbY Xbn Xbq XbZ Xbr XYn XYq XYZ XYr Xnq XnZ Xnr XqZ Xqr XZr bYn bYq bYZ bYr bnq bnZ bnr bqZ bqr bZr Ynq YnZ Ynr YqZ Yqr YZr nqZ nqr nZr qZr";
	@Autowired
	private DataSource dataSource;

	private BatchSqlUpdate insertSql;

	public CartCodeBuilder() {

	}

	public void reCreateUniqueCartCodeForCurrentYear() {
		System.out.println("Cart code generating");
		List<String> uniqueCodeForYearList = new ArrayList<String>(Arrays.asList(uniqueCodeForYear.split(" ")));

		insertSql = new BatchSqlUpdate();
		insertSql.setDataSource(dataSource);
		insertSql.setSql("insert into cart_code (code, date) values ( ?, ?)");
		insertSql.declareParameter(new SqlParameterValue(Types.VARCHAR, "code"));
		insertSql.declareParameter(new SqlParameterValue(Types.DATE, "date"));

		this.addToDB(uniqueCodeForYearList);

	}

	private void addToDB(List<String> data) {
		LocalDate[] future = { LocalDate.now() };
		List<CartCode> icLIST = new ArrayList<CartCode>();
		data.forEach(d -> {
			insertSql.update(d, future[0]);
			icLIST.add(new CartCode(d, future[0]));
			future[0] = future[0].plusDays(1);
		});
		insertSql.flush();
		insertSql.reset();
	}
	public List<CartCode> gene() {
		List<String> data = new ArrayList<String>(Arrays.asList(uniqueCodeForYear.split(" ")));

		LocalDate[] future = { LocalDate.now() };
		List<CartCode> icLIST = new ArrayList<CartCode>();
		data.forEach(d -> {
			icLIST.add(new CartCode(d, future[0]));
			future[0] = future[0].plusDays(1);
		});
		return icLIST;
	}
}
