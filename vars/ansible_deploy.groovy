def call() {
    // Write playbooks from library resources
    writeFile file: 'deploy.yml', text: libraryResource('ansible/deploy.yml')
    writeFile file: 'aws_ec2.yml', text: libraryResource('ansible/aws_ec2.yml')

    // Run Ansible playbook as ubuntu user with the private key
    sh "ansible-playbook -i aws_ec2.yml deploy.yml -u ubuntu --private-key /var/lib/jenkins/.ssh/id_rsa -e 'ansible_ssh_common_args=\"-o StrictHostKeyChecking=no\"'"
}
