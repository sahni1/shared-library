#!/bin/bash

# Exit immediately if any command fails
set -e

# Step 1: Check for Homebrew (macOS package manager)
echo "Checking if Homebrew is installed..."
if ! command -v brew &> /dev/null
then
    echo "Homebrew not found. Installing Homebrew..."
    /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
else
    echo "Homebrew is already installed."
fi

# Step 2: Check if Node.js is installed
echo "Checking if Node.js is installed..."
if ! command -v node &> /dev/null
then
    echo "Node.js not found. Installing Node.js..."
    brew install node
else
    NODE_VERSION=$(node -v)
    echo "Node.js is already installed. Version: $NODE_VERSION"
fi

# Step 3: Check if AWS CLI is installed
echo "Checking if AWS CLI is installed..."
if ! command -v aws &> /dev/null
then
    echo "AWS CLI not found. Installing AWS CLI..."
    brew install awscli
else
    echo "AWS CLI is already installed."
fi

# Step 4: Configure AWS CLI (for setting up AWS credentials)
echo "Configuring AWS CLI (you will need your AWS Access Key and Secret Key)..."
aws configure

# Step 5: Check if AWS CDK is installed globally
echo "Checking if AWS CDK is installed..."
if ! command -v cdk &> /dev/null
then
    echo "AWS CDK not found. Installing AWS CDK globally..."
    npm install -g aws-cdk
else
    echo "AWS CDK is already installed."
fi

# Step 6: Verify AWS CDK installation
echo "Verifying AWS CDK installation..."#!/bin/bash

# Exit immediately if any command fails
set -e

# Step 1: Check for Homebrew (macOS package manager)
echo "Checking if Homebrew is installed..."
if ! command -v brew &> /dev/null
then
    echo "Homebrew not found. Installing Homebrew..."
    /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
else
    echo "Homebrew is already installed."
fi

# Step 2: Check if Node.js is installed
echo "Checking if Node.js is installed..."
if ! command -v node &> /dev/null
then
    echo "Node.js not found. Installing Node.js..."
    brew install node
else
    NODE_VERSION=$(node -v)
    echo "Node.js is already installed. Version: $NODE_VERSION"
fi

# Step 3: Check if AWS CLI is installed
echo "Checking if AWS CLI is installed..."
if ! command -v aws &> /dev/null
then
    echo "AWS CLI not found. Installing AWS CLI..."
    brew install awscli
else
    echo "AWS CLI is already installed."
fi

# Step 4: Configure AWS CLI (for setting up AWS credentials)
echo "Configuring AWS CLI (you will need your AWS Access Key and Secret Key)..."
aws configure

# Step 5: Check if AWS CDK is installed globally
echo "Checking if AWS CDK is installed..."
if ! command -v cdk &> /dev/null
then
    echo "AWS CDK not found. Installing AWS CDK globally..."
    npm install -g aws-cdk
else
    echo "AWS CDK is already installed."
fi

# Step 6: Verify AWS CDK installation
echo "Verifying AWS CDK installation..."
cdk --version

# Step 7: Navigate to the CDK project directory (assuming the script is being run inside the CDK project)
echo "Navigating to the CDK project directory..."
cd "$(pwd)"

# Step 8: Install project dependencies (Assuming package.json exists)
echo "Installing project dependencies..."
npm install

# Step 9: Final Message
echo "Environment setup completed successfully!"
echo "You can now run CDK commands such as 'cdk deploy', 'cdk diff', etc."

cdk --version

# Step 7: Navigate to the CDK project directory (assuming the script is being run inside the CDK project)
echo "Navigating to the CDK project directory..."
cd "$(pwd)"

# Step 8: Install project dependencies (Assuming package.json exists)
echo "Installing project dependencies..."
npm install

# Step 9: Final Message
echo "Environment setup completed successfully!"
echo "You can now run CDK commands such as 'cdk deploy', 'cdk diff', etc."
