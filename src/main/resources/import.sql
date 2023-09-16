-- INSERT MEMBER
INSERT INTO Member (id, userId, email, name, createdDate, modifiedDate) VALUES (1, 'pdohyung', 'pdohyung@naver.com', '도형', now(), now());

INSERT INTO Faq (id, category, question, answer, createdDate, modifiedDate) VALUES (1, 'DEVICE', '하이카디 패치는 무엇을 탐지해 낼 수 있습니까?', '심전도(ECG), 심박수, 심박수 변동성, RR 간격, 호흡수, 체온, 자세(체위), 위치정보를 측정할 수 있으며 데이터로서 기록할 수 있습니다.@또한, 뇌졸중 위험 증가 요인으로 최근 이슈가 되고 있는 심방 세동(AF)을 포함한 15가지 부정맥을 실시간으로 탐지해 낼 수 있습니다.', now(), now());
INSERT INTO Faq (id, category, question, answer, createdDate, modifiedDate) VALUES (2, 'DEVICE', '하이카디 패치의 배터리는 최대 며칠 동안 사용할 수 있나요?', '의사의 처방된 착용 시간에 따라 3일 이내로 패치를 착용하십시오.@하이카디 모델은 24시간, 하이카디 플러스와 하이카디 플러스 홀터 모델은 72시간이 최대입니다.@부정맥 이벤트가 많거나 블루투스 연결 환경이 좋지 않은 경우 배터리 소모가 많아 시간이 감소할 수 있습니다.', now(), now());
INSERT INTO Faq (id, category, question, answer, createdDate, modifiedDate) VALUES (3, 'USE', '하이카디 패치는 어떻게 착용해야 하나요?', '패치는 의료진의 지도에 따라 착용이 진행됩니다. 패치 착용 전 전극의 접착력에 방해될 만한 요소들(접착이 되지 않을 정도의 가슴 모, 각질 등)을 제거하시는 걸 권장해 드리며 알코올 스왑으로 착용 부위를 소독합니다.@여성의 경우 평편한 부분에 패치를 부착해 주십시오. 볼록한 가슴 부위는 측정이 정확하지 않을 수 있습니다.', now(), now());
INSERT INTO Faq (id, category, question, answer, createdDate, modifiedDate) VALUES (4, 'USE', '패치에 부착된 전극은 얼마나 부착하고 있어야 하나요?', '접착력에 문제가 없다면, 검사 기간 동안 교체하지 않으셔도 됩니다. 단, 접착력에 문제가 발생했을 경우에는 교체해 주시는 것을 권장 드립니다.@사람마다 피부 상태가 다양합니다. 동물 임상까지 테스트된 하이카디 전극이지만, 피부 민감도가 높은 경우에는 트러블 발생이 될 수밖에 없습니다. 환자에게 땀이 많은 편인가를 물어보는 것도 의료진의 확인사항 중 하나로 생각해도 좋겠습니다.@보통 홀터로 3일 정도 부착하고 나가는 경우 환자에게 여유 전극 1~2개 정도를 같이 제공하는 것을 추천드립니다.', now(), now());
INSERT INTO Faq (id, category, question, answer, createdDate, modifiedDate) VALUES (5, 'DEVICE', '하이카디 패치를 착용하고 샤워할 수 있나요?', '패치의 IP 등급(방진, 방수 등급)은 IP67로서 샤워 등의 생활방수는 가능하지만 수영장, 욕조 등과 같이 물속에 잠기는 상황은 피해주시기 바랍니다.', now(), now());
INSERT INTO Faq (id, category, question, answer, createdDate, modifiedDate) VALUES (6, 'DEVICE', '하이카디 패치를 착용 후 일상 활동을 해도 될까요?', '예, 하지만 과도한 땀을 흘리게 하는 활동(마라톤과 같은)은 패치의 접착력을 떨어지게 하여 착용 시간을 단축시킬 수 있습니다. 특히 처음 24시간 동안은 패치가 피부에 완전히 밀착될 수 있도록 이러한 활동을 피하십시오.', now(), now());
INSERT INTO Faq (id, category, question, answer, createdDate, modifiedDate) VALUES (7, 'DELIVERY', '하이카디 제품을 주문했는데 배송은 평균 며칠 정도 걸리나요?', '일부 도서산간 지역은 배송이 불가하거나 배송이 다소 지연될 수 있습니다.@결제 완료 후 영업일 기준 2~5일 이내에 배송이 됩니다. (금요일 오후, 주말/공휴일 결제 건은 3~6일 이내 배송)@브랜드 및 품종이 다른 경우 개별(별도 포장)로 배송될 수 있습니다.', now(), now());
INSERT INTO Faq (id, category, question, answer, createdDate, modifiedDate) VALUES (8, 'DELIVERY', '하이카디 제품을 교환하고 싶은데 가능한가요?', '단순 고객 변심으로 인한 교환·반품 신청은 상품 수령일로부터 7일 이내 가능합니다. 단, 배송 상품 등의 내용이 표시·광고 내용과 다르거나 다르게 이행된 경우에는 상품 등을 수령한 날부터 3개월 이내, 그 사실을 안 날 또는 알 수 있었던 날부터 30일 이내입니다.@의료기관의 경우, 판매사 담당자에게 요청하시면 됩니다. 교환 불가 사유는 제품 구매 안내에서 확인 가능합니다.', now(), now());
INSERT INTO Faq (id, category, question, answer, createdDate, modifiedDate) VALUES (9, 'DEVICE', '하이카디 패치와 스마트폰 간의 연결은 어떻게 이루어지며 연결 범위는 어느 정도 입니까?', '하이카디 패치는 블루투스를 통해 스마트폰과 연결됩니다. 두 장치 간의 연결 범위는 최대 10미터이지만 2미터 간격을 유지하시는 것을 권장 드립니다.@홀터 검사의 경우, 패치로부터 전송된 데이터가 스마트폰 앱에 저장이 됩니다. 실시간 모니터링 모드의 경우, 스마트폰 앱을 통해 실시간으로 서버에 전송이 되어, 의료진용 소프트웨어(라이브스튜디오)에 스트리밍 되기 시작합니다.', now(), now());
INSERT INTO Faq (id, category, question, answer, createdDate, modifiedDate) VALUES (10, 'USE', '하이카디 패치를 착용하는 동안 주의해야 할 사항들은 무엇이 있을까요?', '의료진의 안내 없이는 패치를 절대로 끄지 마십시오.(수면 시에도)@스마트폰의 전원이 꺼지지 않도록, 배터리를 충전해 주시기 바랍니다.@블루투스 연결이 끊어지지 않도록, 패치와 스마트폰의 간격을 2미터 이내로 유지해 주시기 바랍니다.', now(), now());

INSERT INTO Item (id, name, subname, previewImage, price, stock, status, createdDate, modifiedDate) VALUES (1, '하이카디플러스 HiCardi+', '편리하게 심전도 측정, 전송 및 분석.\n더 나은 삶을 위한 스마트한 솔루션 HiCardi+', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/preview1.svg', 2046000, 100, 'SELL', now(), now());
INSERT INTO Item (id, name, subname, previewImage, price, stock, status, createdDate, modifiedDate) VALUES (2, '하이카디플러스 HiCardi+ H100', '메모리 내장형 제품', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/preview2.svg', 1320000, 100, 'SELL', now(), now());
INSERT INTO Item (id, name, subname, previewImage, price, stock, status, createdDate, modifiedDate) VALUES (3, '하이카디 HiCardi', '편리하게 심전도 측정, 전송 및 분석', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/preview3.svg', 1496000, 100, 'SELL', now(), now());
INSERT INTO Item (id, name, subname, previewImage, price, stock, status, createdDate, modifiedDate) VALUES (4, '심전도 전극 리필, 소형 20매', 'ECG Electrodes - standard', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/preview4.svg', 16500, 100, 'SELL', now(), now());
INSERT INTO Item (id, name, subname, previewImage, price, stock, status, createdDate, modifiedDate) VALUES (5, '심전도 전극 리필, 대형 20매', '메모리 내장형 제품', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/preview5.svg', 22000, 100, 'SELL', now(), now());
INSERT INTO Item (id, name, subname, previewImage, price, stock, status, createdDate, modifiedDate) VALUES (6, '노닌 펄스옥시미터 3150', '하이카디 플러스와 연동이 가능한 손목밴드형 산소포화도 측정 장비', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/preview6.svg', 1540000, 100, 'SELL', now(), now());
INSERT INTO Item (id, name, subname, previewImage, price, stock, status, createdDate, modifiedDate) VALUES (7, '노닌 펄스옥시미터 3230', '하이카디 플러스와 연동이 가능한 클립형 산소포화도 측정 장비', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/preview7.svg', 550000, 100, 'SELL', now(), now());
INSERT INTO Item (id, name, subname, previewImage, price, stock, status, createdDate, modifiedDate) VALUES (8, '원격 판독권', '부정맥 전문의 원격 판독 서비스', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/preview8.svg', null, 100, 'SELL', now(), now());
INSERT INTO Item (id, name, subname, previewImage, price, stock, status, createdDate, modifiedDate) VALUES (9, '갤럭시 A13', '하이카디 서비스에 필요한 스마트폰(미개통)', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/preview9.svg', 275000, 100, 'SOLD_OUT', now(), now());

INSERT INTO ItemImage(id, image, itemId, createdDate, modifiedDate) VALUES (1, 'https://hicardi.s3.ap-northeast-2.amazonaws.com/itemImage1.svg', 1, now(), now());
INSERT INTO ItemImage(id, image, itemId, createdDate, modifiedDate) VALUES (2, 'https://hicardi.s3.ap-northeast-2.amazonaws.com/itemImage2.svg', 1, now(), now());
INSERT INTO ItemImage(id, image, itemId, createdDate, modifiedDate) VALUES (3, 'https://hicardi.s3.ap-northeast-2.amazonaws.com/itemImage3.svg', 1, now(), now());
INSERT INTO ItemImage(id, image, itemId, createdDate, modifiedDate) VALUES (4, 'https://hicardi.s3.ap-northeast-2.amazonaws.com/itemImage4.svg', 1, now(), now());
INSERT INTO ItemImage(id, image, itemId, createdDate, modifiedDate) VALUES (5, 'https://hicardi.s3.ap-northeast-2.amazonaws.com/itemImage5.svg', 1, now(), now());
INSERT INTO ItemImage(id, image, itemId, createdDate, modifiedDate) VALUES (6, 'https://hicardi.s3.ap-northeast-2.amazonaws.com/itemImage6.svg', 1, now(), now());
INSERT INTO ItemImage(id, image, itemId, createdDate, modifiedDate) VALUES (7, 'https://hicardi.s3.ap-northeast-2.amazonaws.com/itemImage7.svg', 1, now(), now());

INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate) VALUES(1, 1, 'SmartPatch', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate)  VALUES(2, 1, 'DeviceBody', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate)  VALUES(3, 2, 'SmartPatch', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate)  VALUES(4, 2, 'DeviceBody', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate)  VALUES(5, 3, 'SmartPatch', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate)  VALUES(6, 3, 'DeviceBody', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate)  VALUES(7, 4, 'HicardiOnly', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate)  VALUES(8, 4, 'AdditionalItem', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate)  VALUES(9, 5, 'HicardiPlusOnly', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate)  VALUES(10, 5, 'AdditionalItem', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate) VALUES(11, 6, 'OxygenMeasurement', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate) VALUES(12, 6, 'AdditionalItem', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate) VALUES(13, 7, 'OxygenMeasurement', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate) VALUES(14, 7, 'AdditionalItem', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate) VALUES(15, 8, 'RemoteReading', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate) VALUES(16, 8, 'AdditionalService', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate) VALUES(17, 9, 'SmartPhone', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate) VALUES(18, 9, 'AdditionalItem', NOW(), NOW());

INSERT INTO Notice(id, title, content, istop, file, category, createdDate, modifiedDate) VALUES(1, '의료기기 스타트업, 내수 수출 교두부 확보', '내용', 0, null, 'NEWS', '2023-08-15', '2023-08-15');
INSERT INTO Notice(id, title, content, istop, file, category, createdDate, modifiedDate) VALUES(2, '[2023.08.20 기준] 하이카디 플러스 패치 업데이트 안내', '내용', 1, null, 'UPDATE', '2023-08-20', '2023-08-20');
INSERT INTO Notice(id, title, content, istop, file, category, createdDate, modifiedDate) VALUES(3, '의정부 튼튼어린이병원, 심질환 환아 감시 하이카디플러스 도입', '내용', 0, null, 'NEWS', '2023-08-20', '2023-08-20');
INSERT INTO Notice(id, title, content, istop, file, category, createdDate, modifiedDate) VALUES(4, '[2023.09.17 마감] 하이카디 체험단 모집', '내용', 1, '첨부파일', 'NECESSARY', '2023-09-08', '2023-09-08');
INSERT INTO Notice(id, title, content, istop, file, category, createdDate, modifiedDate) VALUES(5, '하이카디 갤럭시A13 연동 방법', '내용', 0, '첨부파일', 'DATA', '2023-09-08', '2023-09-08');
INSERT INTO Notice(id, title, content, istop, file, category, createdDate, modifiedDate) VALUES(6, '[2023.09.15 마감] 하이카디플러스 소개 및 설명회 참여 인원 모집', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/notice1.svg' , 1, 'hicardi_seminar.jpg(1.8MB)', 'NECESSARY', '2023-09-09', '2023-09-09');
INSERT INTO Notice(id, title, content, istop, file, category, createdDate, modifiedDate) VALUES(7, '하이카디 패치 사용법', '내용', 0, '첨부파일', 'DATA', '2023-09-09', '2023-09-09');
INSERT INTO Notice(id, title, content, istop, file, category, createdDate, modifiedDate) VALUES(8, '하이카디 갤럭시A13 연동 방법', '내용', 0, '첨부파일', 'DATA', '2023-09-09', '2023-09-09');
INSERT INTO Notice(id, title, content, istop, file, category, createdDate, modifiedDate) VALUES(9, '하이카디 패치 사용법', '내용', 0, '첨부파일', 'DATA', '2023-09-10', '2023-09-10');
INSERT INTO Notice(id, title, content, istop, file, category, createdDate, modifiedDate) VALUES(10, '메쥬, "하이카디" 전남대병원과 혁신제품 시범구매사업 진행', '내용', 0, null, 'NEWS', '2023-09-12', '2023-09-12');