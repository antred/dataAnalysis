
INSERT INTO akapp.`dim_node` VALUES (null, 'CREDIT_LEVEL', '4', 'D', NULL, NULL);
INSERT INTO akapp.`dim_node` VALUES (null, 'CREDIT_LEVEL', '5', 'E', NULL, NULL);

UPDATE  akapp.`dim_node` SET NODE_NAME = 'A' WHERE TREE_NO = 'CREDIT_LEVEL' AND NODE_NO = '1';
UPDATE  akapp.`dim_node` SET NODE_NAME = 'B' WHERE TREE_NO = 'CREDIT_LEVEL' AND NODE_NO = '2';
UPDATE  akapp.`dim_node` SET NODE_NAME = 'C' WHERE TREE_NO = 'CREDIT_LEVEL' AND NODE_NO = '3';


UPDATE  akapp.`dim_node` SET NODE_NAME = '��Ѻ��Ȩ������ҵ���ű���' WHERE TREE_NO = 'FILE_TYPE' AND NODE_NO = '26';
UPDATE  akapp.`dim_node` SET NODE_NAME = '��Ȩ�����˱��˵����ű���' WHERE TREE_NO = 'FILE_TYPE' AND NODE_NO = '27';
UPDATE  akapp.`dim_node` SET NODE_NAME = '��Ѻ��Ȩ������ҵ��˾�³�' WHERE TREE_NO = 'FILE_TYPE' AND NODE_NO = '28';
UPDATE  akapp.`dim_node` SET NODE_NAME = '��Ѻ��Ȩ������ҵ���ʱ���' WHERE TREE_NO = 'FILE_TYPE' AND NODE_NO = '29';
UPDATE  akapp.`dim_node` SET NODE_NAME = '��Ȩ�����˱������֤�����渴ӡ��' WHERE TREE_NO = 'FILE_TYPE' AND NODE_NO = '30';
UPDATE  akapp.`dim_node` SET NODE_NAME = '����������Ȩ�ˣ��������ű���' WHERE TREE_NO = 'FILE_TYPE' AND NODE_NO = '31';
UPDATE  akapp.`dim_node` SET NODE_NAME = '����������Ȩ�ˣ������ʲ�����������������ҵ�����ṩ�����ҵ�ʲ���' WHERE TREE_NO = 'FILE_TYPE' AND NODE_NO = '32';
UPDATE  akapp.`dim_node` SET NODE_NAME = '����������Ȩ�ˣ��������֤�����渴ӡ��' WHERE TREE_NO = 'FILE_TYPE' AND NODE_NO = '33';
UPDATE  akapp.`dim_node` SET NODE_NAME = '���ʷ���Ȩ��Ѻ����Ȩ������������' WHERE TREE_NO = 'FILE_TYPE' AND NODE_NO = '34';
UPDATE  akapp.`dim_node` SET NODE_NAME = '����ɹ����ɹ��̲��ų��ߵĹ�Ȩ����֤��' WHERE TREE_NO = 'FILE_TYPE' AND NODE_NO = '35';
UPDATE  akapp.`dim_node` SET NODE_NAME = '�����ˡ���Ȩ�����֤ԭ������ӡ���������ֳ�ǩ��' WHERE TREE_NO = 'FILE_TYPE' AND NODE_NO = '36';
UPDATE  akapp.`dim_node` SET NODE_NAME = '����Ȩ���������Ǽ������顷' WHERE TREE_NO = 'FILE_TYPE' AND NODE_NO = '37';

INSERT INTO akapp.`dim_node` VALUES (null, 'FILE_TYPE', '39', '��Ѻ��ͬԭ��-˫������ǩ�ֺ�', NULL, NULL);
INSERT INTO akapp.`dim_node` VALUES (null, 'FILE_TYPE', '40', '���񱨱�', NULL, NULL);
INSERT INTO akapp.`dim_node` VALUES (null, 'FILE_TYPE', '41', '��˾�³�', NULL, NULL);
INSERT INTO akapp.`dim_node` VALUES (null, 'FILE_TYPE', '42', '���ʱ���', NULL, NULL);
INSERT INTO akapp.`dim_node` VALUES (null, 'FILE_TYPE', '43', '��ҵ���ű���', NULL, NULL);
INSERT INTO akapp.`dim_node` VALUES (null, 'FILE_TYPE', '44', '�Թ���ˮ', NULL, NULL);
INSERT INTO akapp.`dim_node` VALUES (null, 'FILE_TYPE', '45', '�������ű��棨����/ʵ�ʿ����ˣ�', NULL, NULL);

INSERT INTO akweb.`dim_node` VALUES (null, 'CREDIT_LEVEL', '4', 'D', NULL, NULL);
INSERT INTO akweb.`dim_node` VALUES (null, 'CREDIT_LEVEL', '5', 'E', NULL, NULL);


UPDATE  akweb.`dim_node` SET NODE_NAME = 'A' WHERE TREE_NO = 'CREDIT_LEVEL' AND NODE_NO = '1';
UPDATE  akweb.`dim_node` SET NODE_NAME = 'B' WHERE TREE_NO = 'CREDIT_LEVEL' AND NODE_NO = '2';
UPDATE  akweb.`dim_node` SET NODE_NAME = 'C' WHERE TREE_NO = 'CREDIT_LEVEL' AND NODE_NO = '3';

