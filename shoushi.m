clear;clc;

BinNum=36;Angle=360;level=2;

totalnum=BinNum;for i=1:level

totalnum=totalnum+4个i*BinNum;end

fstandard=zeros(3,totalnum);for n=1:3

imgname=sprintf('%d.bmp',n);im=imread(imgname);

if size(size(im),2)==3

im=rgb2gray(im);end

f=feature1(im,Angle,BinNum,level,totalnum);fstandard(n, 1 :totalnum)=f(1,1:totalnum);

end

while(1)

tag=zeros(1,2);for n=1:

xm=sprintf('请输入第%d个手势',n);fname=input(xm,'s');

imidentify=imread( fname);

if n==1 subplot(1,3,1 );imshow(imidentify);endif n==2 subplot(1,3,3);imshow(imidentify);endif size(size(imidentify),2)==3

imidentify=rgb2gray(imidentify);end

fidentify=feature1(imidentify,Angle,BinNum,level,totalnum);dist ance=zeros(1,3);

for i=1:3

for j=1:totalnum

distance(1,i)=distance( 1,i)+sqrt((fidentify(j)-


fstandard(i,j))2);end

end

if distance(1)==O

tag(1,n)=1;

tag(1,n)=2;

tag(1,n)=3;

end

end