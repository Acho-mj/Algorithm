-- 2022년 4월 13일 취소되지 않은 흉부외과(CS) 진로예약 조회
-- 진로예약번호, 환자이름, 환자번호, 진료과코드, 의사이름, 진료예약일시
SELECT APNT_NO, PT_NAME, ap.PT_NO, ap.MCDP_CD, DR_NAME, APNT_YMD
FROM APPOINTMENT ap 
JOIN PATIENT pa ON ap.PT_NO = pa.PT_NO
JOIN DOCTOR doc ON ap.MDDR_ID = doc.DR_ID
WHERE DATE_FORMAT(APNT_YMD, "%Y-%m-%d") = '2022-04-13' AND ap.APNT_CNCL_YN = 'N'
ORDER BY APNT_YMD ASC;
