# ElasticCace Redis Cluster Setup

This article will give over view of setting up Elasticcache-Redis cluster in AWS.

AWS-Elastic cache will support two caching services.

  1.  **Redis Cahce**
  2.  **Memcache**
  
Redis Cache  can be used as in-memory cache or database or message broker based on need.But its
specifically well known for in-memory cache implementation. It's used for most of the enterprise high
demand websites world wide.

<B>In AWS Redis Cluster is designed in such a way that it can be accessed from EC2 instance which is running on same
VPC in which Redis is created. So we need to make sure both Redis Cache and our EC2 instances are in same VPC.</B>

We can still access Redis cache from out side of EC2 and outside of AWS throug NAT instance/gateway but this kind of setup
is not recommanded.

Make sure you select specific region in which Redis needs to be created.

To setup follow below steps.

  1. Create/Launch an EC2 instance.
  2. Create a Redis cache from Elasticcache.
  3. Connect Redis cache from EC2 thorugh Redic-cli.

## 1. Create/Launch an EC2 instance

To Create/Launch an EC2 instance refer page below.

https://github.com/uthircloud/aws/blob/master/EC2/README.md

When launching Redis cache in AWS by default it will run in port 6379.

## 2. Create a Redis cache from Elasticcache

To create Redis cache from services choose Elasticcache and choose Redis.

![RedisChoose](https://user-images.githubusercontent.com/50639924/66123429-fe4ce300-e5af-11e9-8246-50c0c2b8c500.PNG)

Click Create.

![Create](https://user-images.githubusercontent.com/50639924/66123470-1fadcf00-e5b0-11e9-823d-1caa566cec42.PNG)

Choose Redis and give name of cache.

![RedisNaeme](https://user-images.githubusercontent.com/50639924/66123562-5c79c600-e5b0-11e9-8a21-64d98213ae9a.PNG)

<B>Choose NodeType to t2 -> cache.t2.micro as its only eligible for free tier.</B>

![NodeType](https://user-images.githubusercontent.com/50639924/66123698-a9f63300-e5b0-11e9-8d85-85041133d2a7.PNG)

![FreeTier](https://user-images.githubusercontent.com/50639924/66123841-ede93800-e5b0-11e9-9317-c336e80fa129.PNG)

![Save-t2-choose](https://user-images.githubusercontent.com/50639924/66123918-196c2280-e5b1-11e9-9b6c-d2217684dfc4.PNG)

<B>Make sure your selecting only t2 version of Node Type as indicated above to avoid any charges.</B>

In Advanced Settings create a new SubNet group. In this step you can see your running EC2 instance VPCID choose the EC2 instance ID in which your running or conneting Redis. If your running only one EC2 instance that VPCID alone avalibale else multiple VPCID will be there you have to choose your VPCID from which you connect this Redis instance.


![AdSe](https://user-images.githubusercontent.com/50639924/66124536-a5cb1500-e5b2-11e9-91f2-0b08e02348ad.PNG)

Have all other default setting as is and click Create. It will take few minutes to create.Once its created you can see below image in dashboard.

![Available](https://user-images.githubusercontent.com/50639924/66125332-ad8bb900-e5b4-11e9-8d25-53f2eb748328.PNG)


## 3. Connect Redis cache from EC2 thorugh Redic-cli

To connect Redis Cache from EC2 instance we need to enable EC2 ingress network connection between EC2 and Redis.
This can be done by configuring EC2 security group inbound rule to allow inbound traffic on redis port 6379.

To make this configuration edit your EC2 instance securitygroup configuration and configure port 6379 with access anywhere.

![InboundRule](https://user-images.githubusercontent.com/50639924/66206303-b5636000-e67d-11e9-9773-2df684671c88.PNG)

Now we have to install redis-cleint or redis-clin in EC2 this to connect Redis from EC2 using commandline.
To install it login to EC2 and run following commands in order.
<B>
sudo yum install gcc -y
wget http://download.redis.io/redis-stable.tar.gz
tar xvzf redis-stable.tar.gz
rm -f redis-stable.tar.gz
cd redis-stable
sudo make
sudo make install
cd src
</B>

When you execute till above step you navigated to redis src folder.Now run below command to connect your redis instance.

redis-cli -c -h <Your Redis instance address> -p 6379

![RedisprimaryEndpoint](https://user-images.githubusercontent.com/50639924/66126027-6dc5d100-e5b6-11e9-911e-212e9c6ad23c.PNG)

Execute below command (make sure you replace your redis instance address)

<B>redis-cli -c -h myredis-cache.mbokrp.ng.0001.usw2.cache.amazonaws.com -p 6379</B>

If everything successful you will be connected to Redis and you can see below 

![Connected](https://user-images.githubusercontent.com/50639924/66126590-cfd30600-e5b7-11e9-8f2a-f16eaa40e895.PNG)

To check further execute few Redis commands.

**set test myvalue**

**get test**

**flushall**


![Commands](https://user-images.githubusercontent.com/50639924/66126752-293b3500-e5b8-11e9-9453-17734e6b782f.PNG)
