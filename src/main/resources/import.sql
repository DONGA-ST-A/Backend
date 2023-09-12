-- INSERT MEMBER
INSERT INTO Member (id, userId, email, name, createdDate, modifiedDate) VALUES (1, 'pdohyung', 'pdohyung@naver.com', '도형', now(), now());

INSERT INTO Faq (id, category, question, answer, createdDate, modifiedDate) VALUES (1, 'USE', '배터리는 어떻게 교체하나요?', '하이카디 패치의 배터리는 교환이 불가능한 재충전식 내장배터리로 구성되어 있습니다. 방전 후 재충전을 하실 수 있는 충전기를 제공해 드립니다.', now(), now());
INSERT INTO Faq (id, category, question, answer, createdDate, modifiedDate) VALUES (2, 'DELIVERY', '오늘 주문하면 언제 도착하나요?', '배송은 출고 후 도착까지 보통 1~3일 소요됩니다.', now(), now());
INSERT INTO Faq (id, category, question, answer, createdDate, modifiedDate) VALUES (3, 'DEVICE', '구매한 패치에 이상이 있습니다.', '패치에 이상이 있으실 경우 1대1 문의를 이용해 주세요.', now(), now());
INSERT INTO Faq (id, category, question, answer, createdDate, modifiedDate) VALUES (4, 'DELIVERY', '배송 완료라고 문자가 왔는데 6시간이 지난 지금까지도 배송되지 않았습니다.', '1대1 문의를 남겨주시면 택배기사님과 연락 후 조치를 취해드리겠습니다.', now(), now());
INSERT INTO Faq (id, category, question, answer, createdDate, modifiedDate) VALUES (5, 'USE', '만 7세 평균 체중 남아에게 사용해도 괜찮을까요?', '사용해도 괜찮습니다.', now(), now());

INSERT INTO Item (id, name, subname, tags, previewImage, price, stock, status, createdDate, modifiedDate) VALUES (1, '하이카디플러스 HiCardi+', '편리하게 심전도 측정, 전송 및 분석', 'SmartPatch,DeviceBody', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/preview1.svg', 2046000, 100, 'SELL', now(), now());
INSERT INTO Item (id, name, subname, tags, previewImage, price, stock, status, createdDate, modifiedDate) VALUES (2, '하이카디플러스 HiCardi+ H100', '메모리 내장형 제품', 'SmartPatch,DeviceBody', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/preview2.svg', 1320000, 100, 'SELL', now(), now());
INSERT INTO Item (id, name, subname, tags, previewImage, price, stock, status, createdDate, modifiedDate) VALUES (3, '하이카디 HiCardi', '편리하게 심전도 측정, 전송 및 분석', 'SmartPatch,DeviceBody', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/preview3.svg', 1496000, 100, 'SELL', now(), now());
INSERT INTO Item (id, name, subname, tags, previewImage, price, stock, status, createdDate, modifiedDate) VALUES (4, '심전도 전극 리필, 소형 20매', 'ECG Electrodes - standard', 'HicardiOnly,AdditionalItem', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/preview4.svg', 16500, 100, 'SELL', now(), now());
INSERT INTO Item (id, name, subname, tags, previewImage, price, stock, status, createdDate, modifiedDate) VALUES (5, '심전도 전극 리필, 대형 20매', '메모리 내장형 제품', 'HicardiPlusOnly,AdditionalItem', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/preview5.svg', 22000, 100, 'SELL', now(), now());
INSERT INTO Item (id, name, subname, tags, previewImage, price, stock, status, createdDate, modifiedDate) VALUES (6, '노닌 펄스옥시미터 3150', '하이카디 플러스와 연동이 가능한 손목밴드형 산소포화도 측정 장비', 'OxygenMeasurement,AdditionalItem', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/preview6.svg', 1540000, 100, 'SELL', now(), now());
INSERT INTO Item (id, name, subname, tags, previewImage, price, stock, status, createdDate, modifiedDate) VALUES (7, '노닌 펄스옥시미터 3230', '하이카디 플러스와 연동이 가능한 클립형 산소포화도 측정 장비', 'OxygenMeasurement,AdditionalItem', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/preview7.svg', 550000, 100, 'SELL', now(), now());
INSERT INTO Item (id, name, subname, tags, previewImage, price, stock, status, createdDate, modifiedDate) VALUES (8, '원격 판독권', '부정맥 전문의 원격 판독 서비스', 'RemoteReading,AdditionalService', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/preview8.svg', null, 100, 'SELL', now(), now());
INSERT INTO Item (id, name, subname, tags, previewImage, price, stock, status, createdDate, modifiedDate) VALUES (9, '갤럭시 A13', '하이카디 서비스에 필요한 스마트폰(미개통)', 'SmartPhone,AdditionalItem', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/preview9.svg', 275000, 100, 'SOLD_OUT', now(), now());

