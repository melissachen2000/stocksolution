package com.example.myche.stocksolution;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private String[] allStockTickers = {
            "Y","PI","PIHP","TUR","FLW","FCC","SRC","VNE","TWO","TPN",
            "JOB","EGH","AAO","ABE","ABEO","ABI","ABM","AXA","ACI","ACI",
            "ACT","ACH","ACA","ACS","AXD","XLR","ANC","ARA","ACR","ACE",
            "ACE","AKA","ACH","ACH","ACI","ACR","ACM","ACN","ACO","ATV",
            "ADM","ADM","ADA","ADU","AE","IOT","ADI","ADIL","ADM","ADB",
            "ADO","ADT","ADR","ADE","AEI","AM","ADX","ADV","DWM","DWS",
            "AC","AEG","AGL","AEH","AMT","AER","AVA","ARP","AEZ","AEM",
            "GNM","AFM","AGE","AGR","AGY","AGI","AGM","AGN","AGNC","AGNC",
            "AGF","AGFS","ALR","AIM","AIR","ATS","AIR","AMC","AKA","AKT",
            "AKC","AKB","AKE","AKR","AKT","ALR","ALS","ALA","ALAC","ALAC",
            "ALAC","ALB","ABD","ALD","ALD","ALX","ALC","ALG","ALI","ALY",
            "ALJ","ALK","ALL","ABT","ALG","ALG","ALGR","ALGR","ALGR","ALN",
            "AMM","ARL","AHP","AMO","ALQ","ALL","ALL","MDR","ALN","AOS",
            "GOO","GOOG","SMC","ATE","ALP","AM","AMRW","AAB","ALT","AL",
            "ASP","AIM","ALT","ALTM","ALZ","AMA","AMA","AMR","AMR","AMZ",
            "AMB","AMBC","AMB","AMC","AMCI","DO","AME","UHA","AMR","AMRH",
            "ATA","AMO","AA","AET","AFI","AMN","ANA","AOB","APE","AMR",
            "AMSW","AMS","AMW","CRM","ABC","AMS","ASR","ASRV","ATL","AMG",
            "FOL","AMK","AMP","IBU","ASY","AMR","AD","ANA","AVX","ANG",
            "ANG","ANI","ANI","ANI","ANS","ATR","APL","APO","APE","AIN",
            "AME","APP","APP","AAP","ARC","APD","APDN","AGT","AMA","AAO",
            "ARE","APT","APR","APV","APT","APT","AQM","AQ","AQS","AQX",
            "ARD","PET","ARA","ABU","ARC","ABI","RKD","ARC","ACG","ACGL",
            "ACGL","FU","ARC","ARC","ARD","ARN","ARC","ARG","ARD","ARK",
            "ART","ARQ","ARR","ARR","DWC","DWA","ARO","ARW","ASN","ARTN",
            "ART","ARV","ARY","ARYA","ARYA","ASN","ASN","ASCM","APW","ASL",
            "ASM","ASP","AZP","ASM","ASR","ASF","AST","ATR","ALO","AST",
            "ASU","AS","ATA","ATR","ATH","ATN","ATH","AAM","ACB","A",
            "ATL","AAW","AF","AFHB","TEA","ATN","ATO","ATO","ATR","ATR",
            "ATI","ATIS","ATT","LIF","AUB","BOL","AUD","AEY","AUP","EAR",
            "J","ADS","AUT","AD","AUT","AVD","AVC","ATX","AVE","AVN",
            "CDM","CDMO","AVI","AVG","CA","AHP","AHPA","AHPA","AV","AVR",
            "AWR","ACL","AXG","AAX","AXN","AXON","AXS","AXT","AYT","AZR",
            "BCO","RIL","RILY","RILY","RILY","RILY","RILY","BOS","BID","BCP",
            "BLD","BAN","BANF","BCT","BAN","BF","BOC","BMR","BML","BKS",
            "BOT","OZ","BSV","BFI","BWF","BAN","BZU","DFV","DFV","DLB",
            "DTU","DTU","DTY","DTY","FLA","STP","TAP","BBS","BSE","ZTES",
            "BCM","BCB","BEC","BBG","BBB","BGN","BELF","BELF","BLP","BLC",
            "BNC","BNF","BNT","BNTC","BR","BYS","BGC","BGF","BRP","BRPA",
            "BRPA","BRPA","BIL","BAS","ORP","BIO","BCR","BDS","BFR","BII",
            "BHT","BKY","BIO","BLF","BLR","BMR","BMR","BNG","BNGO","BVX",
            "BVXV","BPT","BIO","BSG","BST","TEC","BEA","BTA","BCA","BCAC",
            "BCAC","BCAC","BJR","BBO","BRA","BRAC","BRAC","BRAC","BLK","B",
            "BKC","TCP","BLN","BLNK","BLM","BCO","BLB","BHB","BLU","BKE",
            "BKEP","BPM","ITE","BMC","WIF","BOJ","BOK","BOKF","BNS","BKN",
            "BRQ","BOM","BPF","EPA","BOX","BWMC","BCL","BVNS","BDG","BLIN",
            "BW","BRI","BCO","BH","BHFA","AVG","BVS","BYF","BWE","BP",
            "BP","BPRA","BRK","BRK","DOO","BRK","BMT","BLM","BSQ","BLD",
            "BFS","CFF","CHR","CCM","CDN","CDZ","CZ","CST","CLB","CH",
            "CH","CC","CH","CG","CS","CAM","CVG","CAL","CAL","CLM",
            "CRUS","CLX","ABC","CAT","CA","CAM","CSI","CGI","CPH","CBN",
            "CCB","CPL","CSW","CSWC","CPT","CPTA","CPTA","CFF","CAP","CST",
            "CPS","CAR","CBL","CAR","CSI","CDL","CAT","CDN","CEC","CTR",
            "CAR","CAR","CAR","CRZ","TAS","CAR","CAS","CAS","CWS","CAS",
            "CAS","CAS","CAT","CBI","CPR","CAT","CAT","CATY","CGVI","CIVE",
            "CVC","CBF","CBA","CBM","CBO","CBT","CD","CD","CEC","CEL",
            "CEL","CELG","CLD","APO","APOP","CLR","CLRB","CLRB","CLL","CBM",
            "CLS","CEL","CYA","CET","CETX","CETX","CDE","CSF","CET","CFB",
            "CEN","CENT","CVC","CNT","CTR","CEN","CNBK","CNT","CRN","CER",
            "CER","CER","KOO","CEV","CSB","CYO","BUR","CTH","GTL","CHT",
            "CTA","CTAC","CTAC","CHK","CHE","CHEK","CHEK","CKP","CEM","CHF",
            "CCX","CHM","CHK","CHF","CHM","CSS","CSSE","PLC","CMR","CAD",
            "CAA","CBP","CCC","GL","CCR","JRJ","HGS","CIF","CJJ","CLD",
            "CHN","CRE","CNT","CXD","CCI","CNE","IMO","CDX","CHSC","CHSC",
            "CHSC","CHSC","CHSC","CHD","CHU","CDT","CMC","CMCT","CMP","CIN",
            "CID","CTA","CRU","CSC","CTR","CTX","CTXR","CZN","CZW","CZF",
            "CIZ","CTX","CHC","CIV","CIVB","CLA","CLN","CAC","YLD","LRG",
            "CLF","CLR","CLS","CLI","CLIR","CMT","CBL","CLV","CLP","CMF",
            "CMFN","CMS","CMSS","CMSS","CMSS","CM","CCN","CC","COK","COC",
            "COD","CDX","COD","CVL","JV","CCO","CGN","CTS","CWB","COH",
            "CHR","COH","CLC","COL","CIG","CLG","CBA","COL","CLB","COL",
            "CMC","CMCS","CCN","CBS","CBSH","CVG","COM","JC","ESX","CFB",
            "CYHH","CTB","CWB","CVL","CGE","CPS","CT","SCO","CHC","CMT",
            "CNA","CNC","BBC","BBCP","CDO","CFM","CNF","CNFR","CNM","CTW",
            "CNO","CON","CNS","CWC","CNA","CNAC","CNAC","CNAC","CNS","ROA",
            "CPS","CFR","CTR","CTR","CVO","AWS","CPR","CRB","COR","COR",
            "CSO","COR","CRV","CRV","CSG","COS","CPA","ICB","COU","CVT",
            "COW","COWN","COWN","PMT","CPS","CRA","CBR","BRE","CRA","CRE",
            "CREX","CAC","DGL","DSL","GLD","SLV","TVI","UGL","USL","USO",
            "VII","ZI","CRE","CRES","CRN","CRS","CRT","CRO","CRO","CCR",
            "CRW","CYR","CYRX","CSG","CCL","CSP","CSW","CS","CTI","CTI",
            "CTR","CU","CU","CPI","CML","CRI","CUT","CVB","CV","CYA",
            "CYB","CYB","CYC","CYCC","CBA","C","CYR","CON","CYT","CTM",
            "CYT","CYTX","CYTX","CTS","CYT","DJC","DAK","DAR","DRI","DRIO",
            "DZS","DSK","DSKE","DAI","DWC","PLA","DTE","DFN","DIN","DUS",
            "DWL","DWS","DBV","DDM","DDMX","DDMX","DCP","DFR","TAC","TACO",
            "DMP","DEL","DNL","DEN","XRA","DER","DES","DXL","DSW","DTR",
            "DXC","DFB","DFBH","DFBH","DHX","DMA","DHI","FAN","DCI","DRN",
            "DFF","DGI","DMR","DRA","DGL","APP","DCO","DIO","DISC","DISC",
            "DISC","DIS","DVC","SAU","DLH","BOO","DNB","DOC","DOG","DLT",
            "DLP","DLPN","DOM","DGIC","DGIC","DML","DOR","DOV","LY","DOT",
            "DOTA","DOTA","DOTA","DB","DCA","DRY","DSP","DLT","DNK","DRR",
            "DXP","DYS","DYN","DVA","ETF","SS","EBM","EGB","EGL","EFB",
            "EGR","EWB","EM","EAS","EVGB","EVST","EVFT","EVLM","OKDC","EBA",
            "EBAY","EBI","ECH","SAT","EE","ESE","EDA","EDG","EDN","EDI",
            "EDT","EDTX","EDTX","EDU","EGA","EHT","EID","EIG","EKS","LOC",
            "EMIT","ESL","ER","SOL","SOLO","ESI","ECO","E","EFI","ELS",
            "ESB","ELO","ELT","EMC","EMC","EMK","EMM","NYN","ENT","ECP",
            "WIR","END","ECY","ELG","NDR","NDRA","EIG","WAT","EFO","ERI",
            "EN","ENP","ESG","ESGR","ESGR","ETT","ENF","ENT","ENT","ENTX",
            "EBT","EFS","EPZ","PLU","E","EQI","EQB","ERI","ERI","ERY",
            "ESC","ESP","ES","ESS","EPI","ESN","EST","EST","ESTR","VBN",
            "VUS","VID","ETO","ETS","CLW","EDR","EEF","ESE","EVL","EVB",
            "EV","EVE","MRA","EVL","EVO","EVF","EVG","EVO","EOL","EVO",
            "EXA","FLA","ROB","XEL","EXE","EXF","EXL","EXP","EXP","EXP",
            "EXP","ESR","STA","XO","EXT","EYE","EYEG","EYE","EYP","EZP",
            "FFI","F","FLM","FLMN","DAV","FAN","FAR","FMA","FMN","FAM",
            "FAR","FAS","FA","FAT","FBS","FSA","FSAC","FSAC","FNH","FEN",
            "GS","FFB","FCS","FGE","FDB","ONE","LIO","FDU","FDUS","FRG",
            "FIT","FITB","FIS","FNS","FNJ","FTAC","FEY","FBN","FNL","FRB",
            "BUS","FBI","FCA","FCB","FCNC","FCB","FCC","FDE","FFB","FFBC",
            "FFI","THF","FFN","FFW","FGB","FH","INB","INBK","FIB","FRM",
            "FMB","FMB","FNW","FSF","FSL","FAA","FP","BIC","FB","FTH",
            "FCA","FCA","FTC","FCE","FC","SKY","RND","FD","FDT","FV",
            "F","IF","DDI","DVO","DVL","DWP","DAL","FDN","FE","RNE",
            "FEM","FEM","FTS","FE","FEU","FG","FTG","FTL","HYL","FH",
            "NFT","FTA","FTR","LEG","FPX","FPX","FJ","FE","FT","RNL",
            "FT","FL","LMB","FM","FM","FN","FN","RNM","FN","FA",
            "FA","MDI","MCE","FMH","QAB","ROB","FTX","QCL","GRI","CIB",
            "FTX","CAR","FTX","FTX","FTX","FTX","FON","TDI","FTX","QQE",
            "QQX","QTE","AIR","RDV","RFA","RFD","RFE","RFE","FI","FTS",
            "FY","FY","RNS","FY","SDV","FK","FCV","FDI","FS","FIX",
            "TUS","FK","RND","FUN","FUS","MYF","FCF","SVV","FS","FIS",
            "FIV","FPR","FV","FIV","FLE","FLK","FLX","SKO","LKO","MBS",
            "ASE","ESG","ES","QL","FPA","FPAY","FLX","FLI","FLN","FLD",
            "FFI","FNC","FOM","FOC","FON","FSC","FRS","FOR","FORT","FOR",
            "FRT","FTN","FBI","FBIO","FTS","FMC","FMCI","FMCI","FWR","FOR",
            "FW","FOS","FOX","FRA","FEL","FRE","RAI","FEI","FRP","FTD",
            "FTE","FT","FRP","FSB","FSB","FT","FTE","FCE","FLG","FOR",
            "FL","FUL","FNK","FSN","FTF","FFH","FVC","WIL","GTH","FOAN",
            "GRBI","MOGL","PETZ","GAI","GLP","GAL","GLM","GMD","GLP","GPI",
            "GRM","GAR","GLIB","GLIB","GD","GEM","GEN","GF","GFNC","GFNS",
            "GEN","GNU","GNM","GNC","GHD","GNP","GNT","THR","GEO","GAB",
            "GER","GEV","ROC","GIG","GII","GIL","GIL","GBC","GLA","GLAD",
            "GLAD","GOO","GOOD","GOOD","GOOD","GAI","GAIN","GAIN","LAN","LAND",
            "GLB","GB","EN","GBL","GBLI","GBLI","SEL","GWR","DRI","KRM",
            "EBI","FIN","AI","BFI","SNS","LNG","MIL","CHI","EFA","BOT",
            "CAT","SOC","ALT","SRE","YLC","GLB","GLU","GLY","GOG","GLN",
            "GML","GMLP","DNJ","GDE","GOG","GBD","GTI","GSH","GPR","GPA",
            "GPAQ","GPAQ","GRS","GRSH","GRSH","GO","GOVN","LOP","GRV","GEC",
            "GECC","GECC","GE","GLD","GSB","GNB","GRB","GP","GPR","GCB",
            "GLA","GLAC","GLAC","GLAC","GLR","GRN","GSK","GSU","GRI","GRF",
            "GRI","GRT","GRP","OMA","GGA","GV","GSI","GSV","GTX","GTY",
            "GTYH","GTYH","GBN","GNT","GFE","G","GIF","GUR","GPO","GWP",
            "GWG","GYR","HEE","HL","HNR","HAL","HAL","HB","HLN","HJL",
            "HJLI","HW","HWCP","HAF","HQC","HON","HLI","HFGI","HBI","HCA",
            "HCAP","HA","H","HWK","HWB","HYA","HYAC","HYAC","HAY","HD",
            "HII","HCS","HQ","HST","HTL","HTL","HTB","HEB","HSI","HEL",
            "HMN","HSD","HMT","HNN","HSI","HTB","HFW","HCC","MLH","HRT",
            "HSK","H","HFF","HIB","SNL","HP","HIH","HIM","HIF","HSG",
            "HCC","HCCH","HCCH","HCCH","HMN","HMS","HOL","HOL","HBC","HOM",
            "HFB","HMS","HMT","HTB","FIX","HOF","HOP","HFB","HBN","HZN",
            "HRZ","DA","QYL","HD","HP","TWN","TWNK","HMH","HWC","HOVN",
            "HBM","HTG","HTH","HUB","HSO","HDS","HUN","HUNT","HUNT","HBA",
            "HBAN","HBAN","HUR","HUR","HC","HB","HVB","HYG","HYR","IDS",
            "III","IA","IBK","IBKC","IBKC","ICA","IE","ICC","ICF","ICH",
            "ICL","ICL","ICO","ICU","IPW","IDE","INV","IDR","IDX","IES",
            "IRO","IFM","INF","IIV","KAN","IKN","ILM","ISN","IMM","ICC",
            "IMD","IMG","IMM","IMR","IMRN","IMM","IMP","P","IMM","IM",
            "INC","IND","IBC","IBT","ILP","IDS","INF","INF","IFR","II",
            "IE","IEAW","IMKT","INW","INO","IPH","IOS","INN","ISS","INV",
            "ING","INO","IN","INP","INS","NSI","ISI","INS","INS","III",
            "POD","INS","NTE","IAR","IDT","IMT","INT","NTL","IPC","IPA",
            "ICP","IDC","TIL","LIN","IM","INA","IBO","IMX","ISC","IGL",
            "IIJ","IDX","XEN","INT","IVA","INT","ITC","XO","II","INT",
            "ISR","PL","ADR","ADR","ADR","ADR","PK","PF","PY","PE",
            "PS","PI","PI","PX","PF","PT","PR","DWL","PD","DWA",
            "DWA","DWI","DWT","PT","PU","IDL","PRF","PAG","PSA","PI",
            "PG","PE","IPK","PI","KBW","KBW","KBW","KBW","KBW","LDR",
            "LAL","PNQ","PDB","QQ","USL","PSC","PSC","PSC","PSC","PSC",
            "PSC","PSC","PSC","PSC","ISD","ISD","ISE","IU","IUS","VRI",
            "PH","IST","ISB","ITI","NVI","ION","IOV","IPA","IPG","IPI",
            "CLR","CSM","I","IRM","IRT","IRI","IRD","IRDM","IRB","IRW",
            "IRC","SLQ","ISH","SH","TL","IE","IE","AI","USI","COM",
            "IST","IXU","IUS","IUS","IUS","HEW","SUS","ESG","ESG","ESG",
            "SUS","X","FAL","IFE","IFG","BGR","IG","GNM","HYX","IGI",
            "IGO","EM","MB","JK","ACW","ACW","AAX","EWZ","MCH","SC",
            "EEM","EMX","EUF","IEU","RIN","SD","ENZ","QA","TU","UA",
            "IB","SOX","AMC","EMI","ICL","WOO","IND","IJ","DV","SH",
            "IGS","PF","ISR","IT","ITR","ITR","ITR","IVEN","IVFG","IVFV",
            "IZE","JJS","MAY","JBH","JCO","JKH","JAC","JAG","JAK","JRV",
            "JSM","JSM","JAS","JASN","JAZ","J","JSY","JSYN","JSYN","JSYN",
            "JRS","JBL","JCTC","JM","JBS","JOU","JNC","KAL","KAL","KAL",
            "KMD","KND","KPT","KZI","KBL","KBLM","KBLM","KBLM","KBS","KCA",
            "KCAP","KRN","KELY","KELY","KMP","KFF","KER","KEQ","KTC","KZ",
            "KFR","K","KBA","KI","KGJ","KIN","KNS","KNS","KIR","KTO",
            "KTOV","KLA","KLX","KO","KON","KOP","KRN","KOS","KWE","KTO",
            "KRY","KLI","KUR","KVH","FST","LJP","LSB","LBA","LKF","LAK",
            "LRC","LAM","LAN","LND","LAR","LMR","LMRK","LMRK","LMRK","L",
            "LST","LNT","LTR","LSC","LAU","LAW","LAZ","LCN","LPT","LGC",
            "LTX","DDB","EDB","INF","LVH","SQL","UDB","LAC","LACQ","LACQ",
            "LMA","TRE","LEV","LXR","L","LFA","LFAC","LFAC","LGI","LHC",
            "LLI","LBRD","LBRD","LEXE","LEXE","LBTY","LBTY","LBTY","LIL","LILA",
            "BATR","BATR","FWON","FWON","LSXM","LSXM","LSXM","LTRP","LTRP","LCU",
            "LFV","LWA","LGN","LTB","LPT","LLE","LM","LLN","LMS","LMN",
            "LIN","LEC","LIN","LIND","LPC","YV","LQD","LQD","LFU","LIV",
            "LO","LIV","LPS","LIV","LK","LMF","LMFA","LOG","LOG","LOG",
            "CNC","CHN","LON","LOA","LOAC","LOAC","LOAC","LOO","LOR","LOX",
            "LPL","LRA","LYT","LUL","LIT","LMN","LUN","LB","MBT","MCB",
            "MFN","MTS","MGN","MDG","MAG","MGL","MGT","MGI","MNG","MGY",
            "MHL","MMY","MBU","MLV","MAM","TUS","RPIB","MAN","LOA","MNT",
            "MTE","MNK","MAN","MAR","MCH","MRI","MARP","MRN","MRK","MKT",
            "MRL","MA","MBI","MRT","MML","MRV","MAS","MCF","MTC","MTL",
            "MTR","MA","MAT","MXI","MXW","MZO","MBF","MBFI","MGR","MDC",
            "MDR","MFI","MFIN","MTB","MTBC","MNO","MDS","MDG","MDGS","MDW",
            "MED","MEI","MGT","MLC","MLN","MLN","MEL","MNL","MTS","MEL",
            "AMT","AMTB","MBW","MER","MBI","MRC","EBS","VIV","MRB","MMS",
            "MAC","MRS","MRU","MES","MLA","MES","CAS","MEO","MGE","MGP",
            "MBO","MCH","M","MSF","MST","MVI","MIC","MP","MT","MCE",
            "MBC","MSE","MSB","MSV","MOF","MIM","MND","M","NER","MGE",
            "MRT","MSO","MIN","MIND","MIT","MKS","MMA","MIN","MOB","MMD",
            "MMDM","MMDM","MMDM","MRN","MOG","MTE","MBR","MNT","MOM","MKG",
            "MCR","MDL","MG","MD","MPW","TYP","MNR","MRC","MRCC","MNS",
            "MOR","MO","MOS","MTF","MTFB","MPA","MOT","MPV","MOX","COO",
            "MSB","MTE","MTEC","MTEC","MTS","MUD","MUDS","MUDS","LAB","MBI",
            "MFS","MVB","MYS","MY","MYN","MYND","MYO","MYO","MYR","MYG",
            "NBR","NAK","NND","NAN","NST","NAO","N","N","NSS","NDA",
            "NTR","NAT","NAU","NKS","FIZ","NCM","NCO","NES","NESR","NGH",
            "NGHC","NGHC","NGHC","NGHC","NHL","NHLD","NAT","NR","NSE","EY",
            "NWL","NAI","NHT","NAT","BAB","JS","NAV","NBT","NCS","NEB",
            "NEBU","NEBU","NKT","NMR","NEO","NE","NTG","NEO","NEO","NVC",
            "NEP","UEP","NET","NTA","NTE","NFL","NTG","NTC","NTW","CU",
            "NBI","NUR","NURO","STI","NTR","NBE","NYM","NYMT","NYMT","NYMT",
            "NEW","NLN","NMR","NW","NWS","NEW","NEWT","NEWT","NXE","NXEO",
            "NXEO","NXS","NEX","NXG","NFE","NOD","EGO","NIC","NIC","NCB",
            "NIT","NIH","NI","LAS","NMI","NNB","NDL","NDS","NSY","NB",
            "NTI","NTR","NTRS","NFB","NRI","NWB","NWP","NCL","NWF","NVF",
            "NVM","NOV","NOV","NVA","NVL","NVC","NVM","NVU","NUA","NCN",
            "NTN","NTR","NUV","NVT","QQQ","NVE","NVE","NVD","NXP","NXT",
            "NXT","NXTD","NYM","OII","OVL","OCS","OCSL","OCS","OAS","OBL",
            "OBS","OBC","OPT","OCF","OCL","OFE","OCU","OD","OME","OD",
            "OF","OFSS","OFSS","OCC","OHA","OVB","OHR","OKT","ODF","OLB",
            "ON","OPO","OSB","OSBC","OLL","ZEU","OFL","OME","OMC","O",
            "OTI","ONC","OME","ONT","ONTX","ONC","OHG","OS","OSP","OPB",
            "OTE","OPR","OPE","OPES","OPES","OPG","OPGN","OPH","OPN","OP",
            "OBA","OC","OPR","OPH","OPT","OP","ORM","OSU","ORB","ORB",
            "ORT","ORL","ONV","ORG","SEE","OBN","OES","ORI","ORR","OFI",
            "KID","OSI","OSI","OSM","OS","OTE","OTI","OTT","OTT","OTL",
            "OTLK","OVA","OST","OVI","OXB","OXBR","OXF","OXL","OXLC","OXLC",
            "OXS","OXSQ","PFI","PTS","PCA","VET","PAC","PC","PEI","PMB",
            "PPB","PCR","PAC","PTI","PAA","PAN","PZZ","FRS","PRT","TEU",
            "PNR","PCY","PKB","PKO","PTN","PBH","PAT","PNB","PAT","PEG",
            "PDC","PTE","PAV","PAVM","PAVM","PAY","PCT","PYD","PYP","PBB",
            "CNX","PCM","PCS","PCT","PDC","PDF","PDL","PDL","PDV","SKI",
            "PG","PEE","PEER","PEG","PEN","PVA","PFL","PNN","PWO","WRL",
            "WRLS","WRLS","WRLS","PEB","PEB","PFI","PBC","PBCT","PU","KPF",
            "PE","PRC","PRF","PFM","PER","PES","PPI","PT","PGL","PET",
            "PET","PFS","PGT","PHA","PHI","PHII","PAH","PHI","PHIO","PLA",
            "PIC","PLL","PIR","PP","PD","PM","PNF","P","PPS","PXL",
            "EAG","EAGL","EAGL","PLY","PLX","PLU","PLB","P","PST","PLX",
            "PBS","PNT","PCO","POL","PT","POO","POP","BPO","BPOP","BPOP",
            "PTL","PBP","PC","POW","POW","PRA","PRA","PRA","PRP","AIP",
            "PFB","PLP","PFB","PIN","LEN","PSD","PRG","PSM","PNR","PRM",
            "PRI","PVA","PF","BTE","PXU","GEN","PSE","P","PMO","USM",
            "PS","PRN","PRT","PRTH","PRTH","PDE","IPD","PFI","PGN","PRG",
            "PFP","PRP","PRQ","EQR","BI","UBI","TQQ","ZBI","SQQ","BI",
            "PSE","PTG","PTVC","PTVC","PRT","PT","PRT","PRV","PVB","PRO",
            "PBI","PM","PT","PTC","PUL","PLS","PBY","PAC","PACQ","PACQ",
            "PCY","PRP","PX","QAD","QAD","QCR","QGE","QIW","QRV","QCO",
            "QBA","QLY","QTN","QTR","QTR","QRH","QUI","QDE","QNS","QUM",
            "QTN","QRTE","QRTE","QT","RR","RC","RAR","RAD","RDC","RSY",
            "RDU","RDN","RDW","MET","RMB","RAN","GOL","RND","RP","RAV",
            "RAV","RB","ROL","RIC","RCM","RD","RDI","RGS","BCN","BLC",
            "RL","RNW","R","RET","RCO","REP","RRG","RR","RDV","RDF",
            "RDH","RE","REG","RGN","RGL","RBN","REL","MAR","RNS","REG",
            "ABA","RCI","RGE","REP","RBCA","FRB","REF","RSL","RES","REC",
            "HAI","TOR","ROI","RET","RTR","RVN","RVE","RVL","RWL","RFI",
            "RGC","RYT","RBB","RIB","RIBT","REL","RIG","RNE","RMN","RIO",
            "RED","RTT","RVS","RIV","RCK","RMT","RCK","RMC","ROK","ROS",
            "ROSE","ROSE","ROS","RGL","RTI","RBC","RUB","RMB","RUSH","RUSH",
            "RUT","RYAA","STB","SAN","SCA","SCAC","SCAC","SBR","SAB","SAE",
            "SFE","SAF","SG","SAG","SAI","SAL","SA","SAF","SAS","SGM",
            "SAN","GCVR","SPN","SRP","SVR","SBF","SBFG","SBB","SBA","SCS",
            "SMI","SCH","SRR","SCH","SGM","SCP","SCY","SEA","SBC","ST",
            "SHI","SHIP","SHO","SPN","SGE","EYE","EYES","SEC","SCW","SNFC",
            "SEI","SLC","SI","SI","SEL","SIG","SL","LED","SMT","SENE",
            "SENE","SNE","SN","SNHN","SNHN","AIH","SRT","SRTS","STN","STNL",
            "STNL","SQB","MCR","SRE","SFB","SES","SVB","SGB","SGO","SME",
            "SHS","SHE","PIX","SHL","TYH","SHP","SCV","SHB","SST","SFL",
            "SIF","SIB","SIE","SNN","SIE","BSR","SRR","SWI","SIF","SIG",
            "SGL","SGLB","SGM","SBN","SBNY","SLG","SIL","SLA","SIM","SAM",
            "SSN","SFN","SL","SIN","SBG","SIN","SV","SIN","S","SIR",
            "SIT","SKY","SKY","SWK","SNB","SL","SLMB","SMS","SMSH","SG",
            "SN","SMB","SMS","SMT","SRA","SCK","SOH","SLR","SUN","SED",
            "SLN","SLNO","SLG","SLD","SNG","SNGX","SON","SOF","SNO","SNOA",
            "SON","SPH","SOR","SRN","SOH","SOHO","SOHO","SOHO","SFB","SS",
            "SFS","SMB","SON","SBS","S","SGR","SPK","SPKE","ONC","SPA",
            "SPT","DWF","SPP","SPR","AN","SPE","SP","SAV","STX","SPL",
            "SPO","SPW","SBP","FUN","SF","SPS","SSN","SSL","SSR","STA",
            "STA","STM","STN","SBL","SBLK","SBU","STF","STB","GAS","STC",
            "STL","SMR","STL","STLR","STLR","SBO","STM","SRC","SB","STR",
            "SHO","SSF","SFI","SYB","BAN","STN","SSK","SSY","STR","HND",
            "STR","STR","STR","SBB","SUM","SMM","SSB","SMM","WIS","SNH",
            "SND","SNS","STK","SPW","RU","SUN","SPC","SCO","SG","SUP",
            "SPR","SUR","SGR","SRD","STR","SIV","SVM","SYK","SYM","SYN",
            "SYN","SYN","SNC","SND","SYN","SGY","SYB","SNP","SE","THO",
            "SYP","SYR","TRO","TTO","TRH","TCM","TAI","TL","TTW","TLN",
            "TND","TL","TAN","TAO","TED","TAT","TAY","CGB","AMT","PET",
            "TEC","TCC","TTG","TGL","TGE","TNA","TLG","TEL","TEN","TEN",
            "TZA","TZAC","TZAC","TE","TER","TBN","TSR","TSL","TES","TTE",
            "TTP","TCB","TCBI","TCBI","TCBI","TX","TXR","TFS","TGT","AND",
            "TBB","BPR","C","TCG","CAK","CHE","TCF","DSG","DXY","ENS",
            "XON","FBM","FLI","G","HAB","HCK","HAI","CUB","INT","JYN",
            "KEY","KH","OL","LOV","MS","MDC","MEE","MI","MID","NAV",
            "SLI","STK","OR","PRS","RM","SMP","TS","TT","ULT","YOR",
            "NCT","TXM","TRP","TBP","TS","TCR","TBR","TBRG","TBRG","TIB",
            "TIBR","TIBR","TTT","TT","TLR","TSB","TIP","TIT","TMD","TTN",
            "TVT","TIV","TLS","TKK","TKKS","TKKS","TKKS","TMU","TMS","TOC",
            "TNX","TIS","TOP","TRC","TRM","TOT","TOTA","TOTA","TOTA","TBL",
            "TBLT","TBLT","TSE","CLU","TOW","TPI","TCO","TSC","TWM","TAC",
            "TRN","TG","TBI","T","TANN","TANN","TANN","TZO","TRM","TRV",
            "TPC","TCD","TCB","TDA","TDAC","TDAC","TRI","TR","TRM","TRI",
            "TMC","TMCX","TMCX","TRI","TS","TSCA","TB","TRV","TRO","TRU",
            "THS","TRU","TRS","TRM","TSR","TTE","TTM","T","TC","TUE",
            "TOU","HEA","TWL","TWLV","TWLV","TWLV","FO","FOX","TWI","TWS",
            "TRC","TYM","USC","PRT","USE","GRO","USA","USW","USWS","UBN",
            "UFP","ULT","UCT","UP","RAR","ULB","UMB","UMP","UNA","UBS",
            "UN","QUR","UBC","UBO","UBS","UCB","UCF","UA","UBN","UFC",
            "UIH","UNF","UBF","USL","UTH","U","UNI","UNT","UB","OLE",
            "UEI","UFP","UL","USA","UVS","UMR","UPL","UPW","UON","UONE",
            "URB","URG","URO","ECO","USA","USAT","USA","UTM","UTS","UXI",
            "VCN","VLR","VAL","VL","VLYP","VLYP","VAL","VND","BB","GNR",
            "PP","VWO","VNQ","VCI","VGI","VIG","VYM","VCL","VGL","VMB",
            "VON","VON","VON","VTW","VTW","VTW","VTH","VCS","VTI","VGS",
            "BN","VT","BND","VXU","BND","VEA","VEAC","VEAC","VRE","VRN",
            "VBL","VXR","VBI","VTI","VTIQ","VTIQ","VEC","VEO","VR","VCY",
            "VST","VCE","VRN","VRS","VRS","VBT","VER","VRM","VRN","VRR",
            "VRRM","VRC","VTN","VRT","VER","VI","VIA","VSA","VIA","VIC",
            "VIC","VCT","CI","VSD","CE","CE","CI","CI","CF","CF",
            "CS","CD","CD","VSM","CS","CS","VRA","VKT","VKTX","VBF",
            "VLGE","VIO","VNO","VIR","VTS","VIR","VRT","VRTS","BB","BB",
            "VRT","VTG","V","VT","VIV","VVP","VVU","VO","VOX","VYG",
            "VSE","VTV","VUZ","WTR","WTRH","WB","WAF","WAS","WSB","WV",
            "WST","WCF","WDF","W","WT","WEB","WE","WER","WSB","WTB",
            "WAB","WST","WBN","WD","WNE","WPR","WW","WEY","WHL","WHLR",
            "WHLR","WHLR","WH","WHFB","WHL","WVV","WVVI","WLD","WLF","WLT",
            "WS","WI","WIN","WIN","WIN","WTF","WTFC","WTFC","AGN","CXS",
            "EMC","EMC","DGR","DXG","HYZ","AGZ","WET","DXJ","GUL","HYN",
            "DGR","DGR","WI","WW","WDA","WKH","WRL","WRT","WMG","WMGI",
            "WSF","WVF","WYN","XBI","XEL","XE","XNC","XBI","XEN","XER",
            "XGT","XLN","XOM","XPE","XSP","XTL","XNE","YND","YRI","YTR",
            "YTE","YI","YMA","YOG","YGY","YRC","YEC","Y","ZFG","ZAG",
            "ZLA","ZEA","ZBR","","Z","Z","ZNWA","ZIO","ZION","ZIO",
            "ZIX","ZKI","ZGN","ZSA","Z","ZUM","ZYN","ZNG"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button[] newsbuttons = new Button[20];
        newsbuttons[0] = (Button) findViewById(R.id.getnews01);
        newsbuttons[1] = (Button) findViewById(R.id.getnews02);
        newsbuttons[2] = (Button) findViewById(R.id.getnews03);
        newsbuttons[3] = (Button) findViewById(R.id.getnews04);
        newsbuttons[4] = (Button) findViewById(R.id.getnews05);
        newsbuttons[5] = (Button) findViewById(R.id.getnews06);
        newsbuttons[6] = (Button) findViewById(R.id.getnews07);
        newsbuttons[7] = (Button) findViewById(R.id.getnews08);
        newsbuttons[8] = (Button) findViewById(R.id.getnews09);
        newsbuttons[9] = (Button) findViewById(R.id.getnews10);
        newsbuttons[10] = (Button) findViewById(R.id.getnews11);
        newsbuttons[11] = (Button) findViewById(R.id.getnews12);
        newsbuttons[12] = (Button) findViewById(R.id.getnews13);
        newsbuttons[13] = (Button) findViewById(R.id.getnews14);
        newsbuttons[14] = (Button) findViewById(R.id.getnews15);
        newsbuttons[15] = (Button) findViewById(R.id.getnews16);
        newsbuttons[16] = (Button) findViewById(R.id.getnews17);
        newsbuttons[17] = (Button) findViewById(R.id.getnews18);
        newsbuttons[18] = (Button) findViewById(R.id.getnews19);
        newsbuttons[19] = (Button) findViewById(R.id.getnews20);

        for (int i = 0; i < newsbuttons.length; i++) {
            newsbuttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, NewsActivity.class));
                }
            });
        }

        final TextView[] tickers = new TextView[20];
        tickers[0] = (TextView) findViewById(R.id.ticker01);
        tickers[1] = (TextView) findViewById(R.id.ticker02);
        tickers[2] = (TextView) findViewById(R.id.ticker03);
        tickers[3] = (TextView) findViewById(R.id.ticker04);
        tickers[4] = (TextView) findViewById(R.id.ticker05);
        tickers[5] = (TextView) findViewById(R.id.ticker06);
        tickers[6] = (TextView) findViewById(R.id.ticker07);
        tickers[7] = (TextView) findViewById(R.id.ticker08);
        tickers[8] = (TextView) findViewById(R.id.ticker09);
        tickers[9] = (TextView) findViewById(R.id.ticker10);
        tickers[10] = (TextView) findViewById(R.id.ticker11);
        tickers[11] = (TextView) findViewById(R.id.ticker12);
        tickers[12] = (TextView) findViewById(R.id.ticker13);
        tickers[13] = (TextView) findViewById(R.id.ticker14);
        tickers[14] = (TextView) findViewById(R.id.ticker15);
        tickers[15] = (TextView) findViewById(R.id.ticker16);
        tickers[16] = (TextView) findViewById(R.id.ticker17);
        tickers[17] = (TextView) findViewById(R.id.ticker18);
        tickers[18] = (TextView) findViewById(R.id.ticker19);
        tickers[19] = (TextView) findViewById(R.id.ticker20);

        for (TextView ticker:tickers) {
            ticker.setText("NULL");
        }

        final TextView[] prices = new TextView[20];
        prices[0] = (TextView) findViewById(R.id.price01);
        prices[1] = (TextView) findViewById(R.id.price02);
        prices[2] = (TextView) findViewById(R.id.price03);
        prices[3] = (TextView) findViewById(R.id.price04);
        prices[4] = (TextView) findViewById(R.id.price05);
        prices[5] = (TextView) findViewById(R.id.price06);
        prices[6] = (TextView) findViewById(R.id.price07);
        prices[7] = (TextView) findViewById(R.id.price08);
        prices[8] = (TextView) findViewById(R.id.price09);
        prices[9] = (TextView) findViewById(R.id.price10);
        prices[10] = (TextView) findViewById(R.id.price11);
        prices[11] = (TextView) findViewById(R.id.price12);
        prices[12] = (TextView) findViewById(R.id.price13);
        prices[13] = (TextView) findViewById(R.id.price14);
        prices[14] = (TextView) findViewById(R.id.price15);
        prices[15] = (TextView) findViewById(R.id.price16);
        prices[16] = (TextView) findViewById(R.id.price17);
        prices[17] = (TextView) findViewById(R.id.price18);
        prices[18] = (TextView) findViewById(R.id.price19);
        prices[19] = (TextView) findViewById(R.id.price20);

        for (TextView price:prices) {
            price.setText("$0.00");
        }

        final TextView[] names = new TextView[20];
        names[0] = (TextView) findViewById(R.id.company01);
        names[1] = (TextView) findViewById(R.id.company02);
        names[2] = (TextView) findViewById(R.id.company03);
        names[3] = (TextView) findViewById(R.id.company04);
        names[4] = (TextView) findViewById(R.id.company05);
        names[5] = (TextView) findViewById(R.id.company06);
        names[6] = (TextView) findViewById(R.id.company07);
        names[7] = (TextView) findViewById(R.id.company08);
        names[8] = (TextView) findViewById(R.id.company09);
        names[9] = (TextView) findViewById(R.id.company10);
        names[10] = (TextView) findViewById(R.id.company11);
        names[11] = (TextView) findViewById(R.id.company12);
        names[12] = (TextView) findViewById(R.id.company13);
        names[13] = (TextView) findViewById(R.id.company14);
        names[14] = (TextView) findViewById(R.id.company15);
        names[15] = (TextView) findViewById(R.id.company16);
        names[16] = (TextView) findViewById(R.id.company17);
        names[17] = (TextView) findViewById(R.id.company18);
        names[18] = (TextView) findViewById(R.id.company19);
        names[19] = (TextView) findViewById(R.id.company20);

        for (TextView name:names) {
            name.setText("No company name");
        }

        final Button refresh = (Button) findViewById(R.id.button);
        final EditText maxGetter = (EditText) findViewById(R.id.editText);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int maxPrice;
                try {
                    String maximumStockPrice = maxGetter.getText().toString().trim();
                    maxPrice = Integer.parseInt(maximumStockPrice);
                } catch (Exception e) {
                    maxPrice = 150;
                    maxGetter.setText(Integer.toString(maxPrice));
                }


                String[] stockTickers = new String[20];
                int index = 0;
                for (int i = 0; i < 20; i++) {
                    index = (int) (Math.random() * allStockTickers.length);
                    stockTickers[i] = allStockTickers[index];
                    tickers[i].setText(stockTickers[i]);


                    DataRequest price = new DataRequest(MainActivity.this, prices[i], refresh);
                    price.execute("Stock", "0", stockTickers[i], "latestPrice");

                    DataRequest name = new DataRequest(MainActivity.this, names[i], refresh);
                    name.execute("Stock", "0", stockTickers[i], "companyName");

                    if (prices[i].getText().toString().equals("NONE") || names[i].getText().toString().equals("NONE")) {
                        i--;
                    }
                }
            }
        });
    }

}
