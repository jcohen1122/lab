# <span style="color:#FF5733;"> Amazon Web Services (AWS) Notes</span>

## Table of Contents
[AWS Definitions](#aws-definitions)

[AWS Overview](#aws-overview)

## AWS Definitions
**Elasticity:** The cloud's ability to grow and shrink based on demand/traffic.

**Load Balancing:** Distribute incoming traffic evenly among instances.

**Auto Scaling:** AWS automatically adjusts the number of instances based on traffic.

**Identity and Access Management (IAM):** Manages users, permissions, and security.

**Virtual Private Cloud (VPC):** Personal isolated network with its own rules and walls to connect your instances to.

**Content Delivery Network (CDN):** Helps deliver website's content quickly by storing it across the world.

<span style="color:#FF5733;">**S3 (Simple Storage Service) Bucket:**</span> Like a digital storage bin. Where you store your files, images, etc. S3 buckets are named to organize contents.

**Elastic Compute Cloud (EC2):** An instance you can set up with the OS, software, and config you want.

**Cloud Computing:** Deliver servers, storage, databases, networks, etc over the internet. On demand access to a shared pool of resources.

## AWS Overview

**AWS:** A cloud service provider. Provides:
- Compute (EC2)
- Storage (S3, EBS)
- Databases (DynamoDB)
- Analytics (EMR)
- Networking (VPC)
- Dev tools
- Management tools
- IoT
- Enterprise applications

AWS uses [regions](https://aws.amazon.com/about-aws/global-infrastructure/regions_az/) containing availability zones that allow resources to be stored in a certain location, potentially reducing compute power and latency for users close to that location.