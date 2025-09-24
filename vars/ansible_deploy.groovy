def call() {
    // Write playbooks from library resources
    writeFile file: 'deploy.yml', text: libraryResource('ansible/deploy.yml')
    writeFile file: 'aws_ec2.yml', text: libraryResource('ansible/aws_ec2.yml')
    writeFile file: 'ansible.cfg', text: libraryResource('ansible/ansible.cfg')

    // Run Ansible playbook with explicit config
    sh "ANSIBLE_CONFIG=ansible.cfg ansible-playbook -i aws_ec2.yml deploy.yml"
}
